package enums;

public enum TipoEnum {
	FUTBOL7, BALONCESTO;
	
	public String toString(){
		switch(this){
		case FUTBOL7:
			return "Futbol7";
		case BALONCESTO:
			return "Baloncesto";
		}
		return "";
	}
}
