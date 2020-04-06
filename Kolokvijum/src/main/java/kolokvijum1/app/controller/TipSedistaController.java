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

import kolokvijum1.app.DTO.TipSedistaDTO;
import kolokvijum1.app.model.TipSedista;
import kolokvijum1.app.service.TipSedistaService;


@Controller
@CrossOrigin
@RequestMapping(path = "/tipSedista")
public class TipSedistaController {
	
	@Autowired
	TipSedistaService service;
	ArrayList<TipSedistaDTO> l;
	
	//Dobavi sve
	@RequestMapping(path = "", method = RequestMethod.GET)
	public ResponseEntity<ArrayList<TipSedistaDTO>> dobaviSve(){
		ModelMapper mm = new ModelMapper();
		
		l = new ArrayList<TipSedistaDTO>();
		for(TipSedista x:service.dobaviSve()) {
			l.add(mm.map(x, TipSedistaDTO.class));
		}
		
		return new ResponseEntity<ArrayList<TipSedistaDTO>>(l, HttpStatus.OK);
	}
	
	
	//Dobavi po ID
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<TipSedistaDTO> dobaviPoId(@PathVariable("id") Long id){
		ModelMapper mm = new ModelMapper();
		TipSedista existing = service.dobaviPoId(id);
		
		if(existing == null) {
			return new ResponseEntity<TipSedistaDTO>(HttpStatus.NOT_FOUND);
		}
		TipSedistaDTO obj = mm.map(existing, TipSedistaDTO.class);
		return new ResponseEntity<TipSedistaDTO>(obj, HttpStatus.OK);
		
	}
	
	//Dodavanje novog
	@RequestMapping(path = "", method = RequestMethod.POST)
    public ResponseEntity<TipSedista> dodajNovi(@RequestBody TipSedista obj) {
        if (service.dobaviPoId(obj.getId()) != null) {
            return new ResponseEntity<TipSedista>(HttpStatus.CONFLICT);
        }
        service.save(obj);
        return new ResponseEntity<TipSedista>(HttpStatus.OK);
    }
	
	//Izmena
    @RequestMapping(path = "", method = RequestMethod.PUT)
    public ResponseEntity<TipSedista> izmeni(@RequestBody TipSedista obj) {
    	TipSedista postoji = service.dobaviPoId(obj.getId());
        
        if (postoji == null) {
            return new ResponseEntity<TipSedista>(HttpStatus.NOT_FOUND);
        }

        postoji.setNaziv(obj.getNaziv());
        
        
        service.save(postoji);
        return new ResponseEntity<TipSedista>(HttpStatus.OK);
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
