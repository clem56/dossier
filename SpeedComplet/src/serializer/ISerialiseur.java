package serializer;

public interface ISerialiseur<T> {
	public String serialise(T obj);
	public T deserialise(String chaine);
	public  char getSeparateur();
	
}
