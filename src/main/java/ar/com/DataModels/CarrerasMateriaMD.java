package ar.com.DataModels;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ar.com.model.domain.Carreras;
import ar.com.model.domain.Materias;

public class CarrerasMateriaMD {
	private int carrera;
	private List<String> materia;
	private boolean publico;
	private String resumen;
	private String fileName;
	private MultipartFile file;
	
	public boolean getPublico() {
		return publico;
	}
	public void setPublico(boolean publico) {
		this.publico = publico;
	}
	public String getResumen() {
		return resumen;
	}
	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
	
	public int getCarrera() {
		return carrera;
	}
	public void setCarrera(int carrera) {
		this.carrera = carrera;
	}
	public List getMateria() {
		return materia;
	}
	public void setMateria(List materia) {
		this.materia = materia;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	
	
	
}
