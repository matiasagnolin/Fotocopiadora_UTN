package ar.com.ServiceLayer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import ar.com.StorageExceptions.StorageException;


public class FileSystemStorageService {
	   private Path rootLocation;

	    

	    public FileSystemStorageService() {
			super();
			// TODO Auto-generated constructor stub
		}

	    
	    public void store(MultipartFile file) {
	        try {
	            if (file.isEmpty()) {
	                throw new StorageException("Failed to store empty file " + file.getOriginalFilename());
	            }
	            Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
	        } catch (IOException e) {
	            throw new StorageException("Failed to store file " + file.getOriginalFilename(), e);
	        }
	    }
	    public void init() {
	        try {
	            Files.createDirectory(rootLocation);
	        } catch (IOException e) {
	            throw new StorageException("Could not initialize storage", e);
	        }
	    }
	
	 


}
