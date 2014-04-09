package javatests;

public class CustomHashMap {
	
	private static final int SIZE = 16;
	private Entry table[] = new Entry[SIZE];
			
	class Entry{
		final String key;
		String value;
		Entry next;
		
		public Entry(String k, String v) {
			this.key = k;
			this.value = v;
		}
		
		private String getValue(){
			return value;
		}
		
		private void setValue(String value){
			this.value = value;
		}
		
		private String getKey(){
			return key;
		}
	}
	
	public Entry get(String key){
		int hashCode = Math.abs(key.hashCode()) % SIZE;
		//got hashcode and bucket  , say
		Entry e = table[hashCode];
		while(e != null){
			if(e.key.equals(key)){
				return e;
			}
			e = e.next;
		}
		return null;
	}
	
	public void put(String key, String value){
		int hashcode = Math.abs(key.hashCode()) % SIZE;
		Entry e = table[hashcode];
		
		if(e != null){
			if(e.getKey().equals(key)){
				e.setValue(value);
			}
			else{
				//add the collision entry to the end of bucket
				while(e.next != null){
					e = e.next;
				}
				Entry collisionEntry = new Entry(key,value);
				e.next = collisionEntry;
			}
		}
		else{
			//adding new entry to bucket (linked list)
			Entry newEntry = new Entry(key, value);
			table[hashcode] = newEntry;
		}
	}
	
	public static void main(String args[]){
		CustomHashMap map = new CustomHashMap();
		String a = "Srikanth";
		System.out.println("hashcode of srikanth" + a.hashCode());
		map.put("Srikanth", "Patruni");
		map.put("Darshan", "Raj D");
		map.put("Bijesh", "Chandran");
		map.put("Jayan", "K");
		map.put("Rijesh", "C");
		
		String value = map.get("Bijesh").getValue();
		System.out.println("Bijesh :" + value);
		String value2 = map.get("Rijesh").getValue();
		System.out.println("Rijesh :" + value);
	}

}
