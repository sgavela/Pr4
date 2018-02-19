import java.util.List;

public class Carretera {
    private int _longitud;
    private int _maxVel;
    private List<Vehiculo> _vehiculosEnCarretera;
    private String _identificador;
    
    public Carretera() {
    	
    }
    
    public void entraVehiculo(Vehiculo v) {
    	_vehiculosEnCarretera.add(v);
    }
    
    public void saleVehiculo(Vehiculo v) {
    	int n = _vehiculosEnCarretera.indexOf(v);
    	_vehiculosEnCarretera.remove(n);
    }
    
    public void avanza() {
    	int velocidadBase = min(_maxVel, _maxVel/max(_vehiculosEnCarretera.size(),1));
    	for(Vehiculo v : _vehiculosEnCarretera) { 
    		v.setVelocidadActual(velocidadBase/factorReduccion(_vehiculosEnCarretera));
    	    v.avanza();
    	}
    }
    
    private int factorReduccion(List<Vehiculo> l) {
    	int f = 1;
    	for(Vehiculo v : _vehiculosEnCarretera) {
    		if(v.getTiempoAveria() > 0) f = 2;
    	}
    	return f;
    }

	private int min(int i, int j) {
		if(i <= j) return i;
		else return j;
	}

	private int max(int i, int j) {
		if(i >= j) return i;
		else return j;
	}
	
	public void generaInforme() { //metodo sin acabar!!!
   	    System.out.println("[road_report]");
   	    System.out.println("id = " + _identificador);
   	    System.out.println("time = " + pasoDeLaSimulacion);
   	    String vehiculos = "";
   	    String coma = ",";
   	    String abreParentesis = "(";
   	    String cierraParentesis = ")";
   	    for(Vehiculo v : _vehiculosEnCarretera) {
   		    vehiculos = vehiculos + abreParentesis 
   				    + v.getIdentificador() + coma 
   				    + v.getLocalizacion() + cierraParentesis
   				    + coma;
   	    }
   	    System.out.println("state = " + vehiculos);
	}
}
