package kolokvijum1.app.controller;

import java.util.ArrayList;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kolokvijum1.app.DTO.SedisteDTO;
import kolokvijum1.app.model.Sediste;
import kolokvijum1.app.service.SedisteService;

@Controller
@CrossOrigin
@RequestMapping(path = "/sediste")
public class SedisteController {
	@Autowired
	SedisteService service;
	ArrayList<SedisteDTO> l;
	
	//Dobavi sve
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<SedisteDTO>> dobaviSve(){
		ModelMapper mm = new ModelMapper();
		
		l = new ArrayList<SedisteDTO>();
		for(Sediste x:service.dobaviSve()) {
			l.add(mm.map(x, SedisteDTO.class));
		}
		
		return new ResponseEntity<ArrayList<SedisteDTO>>(l, HttpStatus.OK);
	}
	
	
	//Dobavi po ID
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<SedisteDTO> dobaviPoId(@PathVariable("id") Long id){
		ModelMapper mm = new ModelMapper();
		Sediste existing = service.dobaviPoId(id);
		
		if(existing == null) {
			return new ResponseEntity<SedisteDTO>(HttpStatus.NOT_FOUND);
		}
		SedisteDTO obj = mm.map(existing, SedisteDTO.class);
		return new ResponseEntity<SedisteDTO>(obj, HttpStatus.OK);
		
	}
	
	//Dodavanje novog
	@RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<Sediste> dodajNovi(@RequestBody Sediste obj) {
        if (service.dobaviPoId(obj.getId()) != null) {
            return new ResponseEntity<Sediste>(HttpStatus.CONFLICT);
        }
        service.save(obj);
        return new ResponseEntity<Sediste>(HttpStatus.OK);
    }
	
	//Izmena
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public ResponseEntity<Sediste> izmeni(@RequestBody Sediste obj) {
    	Sediste postoji = service.dobaviPoId(obj.getId());
        
        if (postoji == null) {
            return new ResponseEntity<Sediste>(HttpStatus.NOT_FOUND);
        }

        postoji.setBroj(obj.getBroj());
        postoji.setRed(obj.getRed());
        
        
        service.save(postoji);
        return new ResponseEntity<Sediste>(HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> brisanje(@PathVariable("id") Long id) {
    	
        if (service.dobaviPoId(id) == null) {
            return new ResponseEntity<Object>(HttpStatus.NOT_FOUND);
        }
        
        service.delete(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }
}
