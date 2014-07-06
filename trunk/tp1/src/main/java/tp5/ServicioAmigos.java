package tp5;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.RelationshipType;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.index.Index;

import daos.UsuarioDAO;
import tp1.Usuario;

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
			
		}catch(Exception e){
			
		}
	}
	
	public List<Integer> consultarAmigos(Integer usrID){
		List<Integer> idAmigos = new ArrayList<Integer>();
		
		try{
			Transaction tx = graphDb.beginTx();
	
			Node nodo = this.buscar(usrID);
			
			Iterable<Relationship> relaciones = nodo.getRelationships(); //TODO Ver
			
			for(Relationship r: relaciones){
				idAmigos.add((Integer) r.getEndNode().getProperty("id"));
			}
			
			tx.success();
			
		}catch(Exception e){
			
		}
		
		return idAmigos;
	}
	
	public void enviarMensaje(Integer usrID, String msg, Integer idAmigo){
		//TODO
	}
	
	public void enviarMensajes(Integer usrID, String msg){
		//TODO
	}
	
	public List<String> verContactos(Integer usrID){
		//TODO
		return null;
	}
	
	//------------------------------------------------------------
	
	public void guardar(Integer usrId) {

		try{
			Transaction tx = graphDb.beginTx();
			
			Node nodo = graphDb.createNode();
			nodo.setProperty("id", usrId);	

			Index<Node> idxNode = graphDb.index().forNodes("id");
			idxNode.add(nodo, "id", usrId);

			tx.success();	
		}catch(Exception e){}

	}
	
	public Node buscar(Integer usrID){
		Node ret;
		Index<Node> idx = graphDb.index().forNodes("id");

		ret = idx.get("id", usrID).next(); 

		return ret;
	}
	
	//------------------------------------------------------------	
	
	private static enum TipoRelacion implements RelationshipType { AMIGOS }
	
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
			
			sa.agregarAmigo(1, 2);
			System.out.println(sa.buscar(1).hasRelationship());
			
			System.out.println(sa.consultarAmigos(1).get(0));
			
			//Usuario usr = new UsuarioDAO().get((Integer) sa.consultarAmigos().get(0).getProperty("id"));
			//System.out.println(usr.getId());
			//System.out.println(usr.getNombreusuario());
			
			tx.success();
			
		}catch(Exception e){}
		
		sa.shutDown();
		
	}

	//
	
}
