package tp6;

import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import net.vz.mongodb.jackson.JacksonDBCollection;
import net.vz.mongodb.jackson.MapReduce;
import net.vz.mongodb.jackson.MapReduce.MapReduceCommand;
import net.vz.mongodb.jackson.MapReduceOutput;
import net.vz.mongodb.jackson.WriteResult;

public class Collection<T> {	
	
	private JacksonDBCollection<T, Integer> mongoCollection;
	
	
	
	public Perfil ret(Integer id) {
		return (Perfil) mongoCollection.findOne(new BasicDBObject("idUsuario", id));	
	}
	
	public WriteResult<T, Integer> insert(T object){
		return mongoCollection.insert(object);
    }
	/*
	public WriteResult<T, String> update(T object){		
		return mongoCollection.update(new BasicDBObject("idUsuario", ((Perfil) object).getIdUsuario()), (DBObject) object);
    }*/
	
	public WriteResult<T, Integer> update(Perfil object){		
		return mongoCollection.update(new BasicDBObject("idUsuario", object.getIdUsuario()), (DBObject) object);
    }
	
	public WriteResult<T, Integer> insert(List<T> object){
		return mongoCollection.insert(object);
    }
	
	public void setMongoCollection(JacksonDBCollection<T, Integer> mongoCollection) {
		this.mongoCollection = mongoCollection;
	}
	
	public JacksonDBCollection<T, Integer> getMongoCollection() {
		return mongoCollection;
	}
	
	/*
	public Collection(JacksonDBCollection<T, String> mongoCollection) {
		this.mongoCollection = mongoCollection;
	}
	*/
	
	
	public Collection(JacksonDBCollection<T, Integer> mongoCollection) {
		this.mongoCollection = mongoCollection;
	}

	
	
	
	/*
	public <E, S> MapReduceOutput<E,S> mapReduce(String map, String reduce, Class<E> entrada, Class<S> salida){
		return mongoCollection.mapReduce(mapReduceCommand(map, reduce, entrada, salida));
	}
	
	public <E, S> MapReduceOutput<E,S> mapReduce(String map, String reduce, String finalize, Class<E> entrada, Class<S> salida){
		return mongoCollection.mapReduce(mapReduceCommand(map, reduce, finalize, entrada, salida));
	}
	
	protected <E, S> MapReduceCommand<E,S> mapReduceCommand(String map, String reduce, Class<E> entrada, Class<S> salida){
		return MapReduce.build(map, reduce, MapReduce.OutputType.INLINE, null, entrada, salida);
	}
	
	protected <E, S> MapReduceCommand<E,S> mapReduceCommand(String map, String reduce, String finalize, Class<E> entrada, Class<S> salida){
		MapReduceCommand<E, S> command = this.mapReduceCommand(map, reduce, entrada, salida);
		command.setFinalize(finalize);
		return command;
	}
	*/
		
	//
}
