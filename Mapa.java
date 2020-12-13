//este es del video 15 
//package mapa;

public abstract class Mapa{
  protected int ancho;
  protected int largo; //alto
  protected int[] cuadros; 
  
  public Mapa(int ancho, int largo){
    this.ancho=ancho;
    this.largo=largo;  
    cuadros = new int[ancho*largo];
    generarMapa();
  }
  
  public Mapa(String ruta){
    cargarMapa(ruta);
  }
  
  protected void generarMapa(){
  
  }
  
  private void cargarMapa(String ruta){
  
  }
  
  public void actualizar(){
  
  }
  
  public void mostrar(final int compensacionX, final int compensacionY, final Pantalla pantalla){
    pantalla.establecerDiferencia(compensacionX, compensacionY);
    int o = compensacionX >> 5;
    int e = (compensacionX + pantalla.getAncho() + 32) >> 5;
    int n = compensacionY >> 5;
    int s = (compensacionY + pantalla.getLargo() + 32) >> 5;
    for(int y = n; y < s; y++){
      for(int x = o; x < e; x++){
        getCuadro(x, y).mostrar(x, y, pantalla);
      }
    }
  }
  public Cuadro getCuadro(final int x, final int y){
    if(x < 0 || y < 0 || x >= ancho || y >= largo){
      return Cuadro.VACIO;
    }
    switch(cuadros[x + y * ancho]){
      case 0: return Cuadro.ASFALTO;
      case 1:
      case 2:
      case 3:
      default: return Cuadro.VACIO;
    }
  }
}
