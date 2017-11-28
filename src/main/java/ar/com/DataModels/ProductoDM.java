package ar.com.DataModels;

public class ProductoDM {
private String Comment;
private String name;
private int IdArchivo;
private boolean Aprobado; 
public boolean isAprobado() {
	return Aprobado;
}
public void setAprobado(boolean aprobado) {
	Aprobado = aprobado;
}
public String getComment() {
	return Comment;
}
public void setComment(String comment) {
	Comment = comment;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getIdArchivo() {
	return IdArchivo;
}
public void setIdArchivo(int idArchivo) {
	IdArchivo = idArchivo;
}




}
