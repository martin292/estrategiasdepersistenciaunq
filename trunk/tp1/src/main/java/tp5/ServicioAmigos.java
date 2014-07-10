package tp5;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.neo4j.cypher.javacompat.ExecutionEngine;
import org.neo4j.cypher.javacompat.ExecutionResult;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.index.Index;


public class ServicioAmigos {

	//--------------------------------------------------------------
		
	protected GraphDatabaseService graphDb;
	private static final String DB_PATH = "target/neo4j-aterrizar-db";
	
			
	//---------------------------------------------------------------
	
	public void agregarAmigo(Integer usrID, Integer idAmigo){
		try{
			Transaction tx = graphDb.beginTx();
	
			Node nodeUSR = this.buscar(usrID);
			Node nodeAMIGO = this.buscar(idAmigo);
			
			nodeUSR.createRelationshipTo(nodeAMIGO, TipoRelacion.AMIGOS);
			
			tx.success();
			
		}catch(Exception e){}
	}
	
	public List<Integer> consultarAmigos(Integer usrID){
		List<Integer> idAmigos = new ArrayList<Integer>();
		
		try{
			Transaction tx = graphDb.beginTx();
	
			Node nodo = this.buscar(usrID);
			
			Iterable<Relationship> relaciones = nodo.getRelationships();
			
			for(Relationship r: relaciones){
				idAmigos.add((Integer) r.getEndNode().getProperty("id"));
			}
			
			tx.success();
			
		}catch(Exception e){}
		
		return idAmigos;
	}
	
	public void enviarMensaje(Integer usrID, String msg, Integer idAmigo){
		try{
			Transaction tx = graphDb.beginTx();
	
			Node nodeUSR = this.buscar(usrID);
			Node nodeAMIGO = this.buscar(idAmigo);
			
			Node nodeMSG = graphDb.createNode();
			nodeMSG.setProperty("mensaje", msg);
			
			nodeUSR.createRelationshipTo(nodeMSG, TipoRelacion.EMISOR);
			nodeAMIGO.createRelationshipTo(nodeMSG, TipoRelacion.RECEPTOR);
			
			tx.success();
			
		}catch(Exception e){}
	}
	
	/*
	public List<String> verContactos(Integer usrID){
		ExecutionEngine motor = new ExecutionEngine( graphDb );
		ExecutionResult resultado;
		List<String> contactos = new ArrayList<String>();
		
		try{
			Transaction tx = graphDb.beginTx();
	
			resultado = motor.execute(" QUERY "); //
			
			contactos = resultado.columns(); //
			
			tx.success();
			
		}catch(Exception e){}
		
		return contactos;
	}
	*/
	
	//TODO
	public List<Integer> verContactos(Integer usrID){
		List<Integer> idAmigos = new ArrayList<Integer>();
				
		for(Integer amigo: this.consultarAmigos(usrID)){
			if(!idAmigos.contains(amigo)){
				idAmigos.add(amigo);
			}
			idAmigos.addAll(this.verContactos(amigo));			
		}
		
		return idAmigos;
	}
	
	
	//------------------------------------------------------------
	
	public void guardar(Integer usrId) {

		try{
			Transaction tx = graphDb.beginTx();
			
			Node nodo = graphDb.createNode();
			nodo.setProperty("id", usrId);	

			Index<Node> idxNode = graphDb.index().forNodes("id");
			idxNode.add(nodo, "id", nodo.getProperty("id"));

			tx.success();	
		}catch(Exception e){}

	}
	
	public Node buscar(Integer usrID){
		return graphDb.index().forNodes("id").get("id", usrID).getSingle();
	}
	
	//------------------------------------------------------------	
	
	private static enum TipoRelacion implements RelationshipType { AMIGOS, EMISOR, RECEPTOR }
	
	public void crearDB(){
		deleteFileOrDirectory( new File( DB_PATH ) );
		
		graphDb = new GraphDatabaseFactory().newEmbeddedDatabase( DB_PATH );
		registerShutdownHook( graphDb );
	}
	
	public void shutDown(){
        System.out.println();
        System.out.println( "Shutting down database ..." );
        graphDb.shutdown();
    }
	
	private static void registerShutdownHook( final GraphDatabaseService graphDb ) {
        Runtime.getRuntime().addShutdownHook( new Thread()
        {
            @Override
            public void run()
            {
                graphDb.shutdown();
            }
        } );
    }
	
	private static void deleteFileOrDirectory( File file ){
		if ( file.exists() ){
			if ( file.isDirectory() ){
				for ( File child : file.listFiles() ){
					deleteFileOrDirectory( child );
	            }
	        }
			file.delete();
	    }
	}	
	
	//-----------------------------------------------------
	
	
	public static void main(String[] args) {
		
		ServicioAmigos sa = new ServicioAmigos();
		
		sa.crearDB();
		
		try{
			Transaction tx = sa.graphDb.beginTx();
			
			sa.guardar(1);
			System.out.println(sa.buscar(1).getProperty("id"));
			
			sa.guardar(2);
			System.out.println(sa.buscar(2).getProperty("id"));
			
			sa.guardar(3);
			System.out.println(sa.buscar(3).getProperty("id"));
			
			sa.agregarAmigo(1, 2);
			sa.agregarAmigo(1, 3);
			System.out.println(sa.buscar(1).hasRelationship());
			
			sa.enviarMensaje(1, "Hola", 2);

			for(Relationship r: sa.buscar(1).getRelationships()){
				System.out.println(r.getEndNode().hasRelationship(TipoRelacion.EMISOR));
			}
			
			sa.guardar(4);
			sa.guardar(5);
			sa.agregarAmigo(2, 3);
			sa.agregarAmigo(3, 4);
			sa.agregarAmigo(3, 5);
			sa.agregarAmigo(5, 2);
			
			System.out.println(sa.consultarAmigos(1).get(0));
			System.out.println(sa.consultarAmigos(1).get(1));
			
			//System.out.println(sa.verContactos(1));
			
			tx.success();
			
		}catch(Exception e){}
		
		sa.shutDown();
		
	}

	//
	
}
