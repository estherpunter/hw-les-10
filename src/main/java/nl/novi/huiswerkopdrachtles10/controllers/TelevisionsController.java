package nl.novi.huiswerkopdrachtles10.controllers;

import nl.novi.huiswerkopdrachtles10.televisions.Television;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("televisions")
public class TelevisionsController {

    private Long currentId = 1L;

    private List<Television> televisionList = new ArrayList<Television>();

    //    GET-request voor alle televisies
    @GetMapping
    public ResponseEntity<List<Television>> getTelevisions() {
        return ResponseEntity.ok(televisionList);
    }

    //    GET-request voor 1 televisie
    @GetMapping("/{id}")
    public ResponseEntity<Television> getTelevision(@PathVariable Long id) {
        var optionalTv = findTvById(id);
        if (optionalTv == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(optionalTv);
    }

    private Television findTvById(Long id) {
        for (Television television : televisionList) {
            if (television.getId().equals(id)) {
                return television;
            }
        }
        return null;
    }


//    POST-request voor 1 televisie

    @PostMapping("/{id}")
    public ResponseEntity<Television> createTelevision(@RequestBody Television television) {
        television.setId(currentId++);
        televisionList.add(television);
        return ResponseEntity.status(HttpStatus.CREATED).body(television);
    }


//    PUT-request voor 1 televisie

    @PutMapping("/{id}")
    public ResponseEntity<Television> updateTelevision(@PathVariable Long id, @RequestBody Television television) {
        var existingTv = findTvById(id);
        if (existingTv == null) {
            return ResponseEntity.notFound().build();
        }
        existingTv.setBrand(television.getBrand());
        existingTv.setModel(television.getModel());
        return ResponseEntity.ok(existingTv);
    }


//    DELETE-request voor 1 televisie
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelevision(@PathVariable Long id) {
        var optionalTv = findTvById(id);
        if (optionalTv == null) {
            return ResponseEntity.notFound().build();
        }
        televisionList.remove(optionalTv);
        return ResponseEntity.noContent().build();
    }

}
