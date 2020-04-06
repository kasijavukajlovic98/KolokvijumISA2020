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

import kolokvijum1.app.DTO.KartaDTO;
import kolokvijum1.app.model.Karta;
import kolokvijum1.app.service.KartaService;

@Controller
@CrossOrigin
@RequestMapping(path = "/karta")
public class KartaController {
	
	@Autowired
	KartaService service;
	ArrayList<KartaDTO> l;
	
	//Dobavi sve
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<KartaDTO>> dobaviSve(){
		ModelMapper mm = new ModelMapper();
		
		l = new ArrayList<KartaDTO>();
		for(Karta x:service.dobaviSve()) {
			l.add(mm.map(x, KartaDTO.class));
		}
		
		return new ResponseEntity<ArrayList<KartaDTO>>(l, HttpStatus.OK);
	}
	
	
	//Dobavi po ID
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<KartaDTO> dobaviPoId(@PathVariable("id") Long id){
		ModelMapper mm = new ModelMapper();
		Karta existing = service.dobaviPoId(id);
		
		if(existing == null) {
			return new ResponseEntity<KartaDTO>(HttpStatus.NOT_FOUND);
		}
		KartaDTO obj = mm.map(existing, KartaDTO.class);
		return new ResponseEntity<KartaDTO>(obj, HttpStatus.OK);
		
	}
	
	//Dodavanje novog
	@RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<Karta> dodajNovi(@RequestBody Karta obj) {
        if (service.dobaviPoId(obj.getId()) != null) {
            return new ResponseEntity<Karta>(HttpStatus.CONFLICT);
        }
        service.save(obj);
        return new ResponseEntity<Karta>(HttpStatus.OK);
    }
	
	//Izmena
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public ResponseEntity<Karta> izmeni(@RequestBody Karta obj) {
    	Karta postoji = service.dobaviPoId(obj.getId());
        
        if (postoji == null) {
            return new ResponseEntity<Karta>(HttpStatus.NOT_FOUND);
        }

        postoji.setKupljena(obj.getKupljena());
        
        
        service.save(postoji);
        return new ResponseEntity<Karta>(HttpStatus.OK);
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
