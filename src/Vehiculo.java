import java.util.Collection;
import java.util.List;

public class Vehiculo {
	 String _identificador;
     private int _velMaxima;
     private int _velActual;
     private Carretera _carretera;
     private int _localizacion;
     private List<Carretera> _itinerario;
     private int _puntoDelItinerario;
     private int _tiempoAveria;
     private boolean _haLlegado;
     
     public Vehiculo(){
    	 
     }
     
     public void avanza() {
    	 if(_tiempoAveria == 0) {
    		 _localizacion = _localizacion + _velActual;
    		 if(_localizacion >= _carretera.getLongitud()) {
    			 _localizacion = _carretera.getLongitud();
    			 // aqui puede ser que falte codigo
    		 }
    	 } else {
    		 _tiempoAveria--;
    	 }
     }
     
     public void moverASiguienteCarretera(Carretera siguienteCarretera) {
    	 if(_puntoDelItinerario < _itinerario.size()) {
    	     _carretera = _itinerario.get(_puntoDelItinerario);
    	     _localizacion = 0;
    	     _puntoDelItinerario++;
    	 } else  _haLlegado = true;
     }
     
     public String getIdentificador() {return _identificador;}
     
     public int getLocalizacion() {return _localizacion;}
     
     public int getTiempoAveria() {return _tiempoAveria;}
     
     public void setTiempoAveria(int n) {_tiempoAveria = n;}
     
     public void setVelocidadActual(int vel) {
    	 if(vel <= _velMaxima) _velActual = vel;
    	 else _velActual = _velMaxima;
     }
     
     public void generaInforme() { //metodo sin acabar!!!
    	 System.out.println("[vehicle_report]");
    	 System.out.println("id = " + _identificador);
    	 System.out.println("time = " + pasoDeLaSimulacion);
    	 System.out.println("speed = " + _velActual);
    	 System.out.println("faulty = " + _tiempoAveria);
    	 if(!_haLlegado) 
    		 System.out.println("location = (" + _carretera.getIdentificador + "," + _localizacion + ")");
    	 else 
    		 System.out.println("arrived");
     }
}
