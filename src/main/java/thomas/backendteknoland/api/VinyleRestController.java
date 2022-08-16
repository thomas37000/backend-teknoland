package thomas.backendteknoland.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import thomas.backendteknoland.bo.Vinyle;
import thomas.backendteknoland.service.VinyleService;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/vinyles")
public class VinyleRestController {
    @Autowired
    VinyleService vinyleService;

    @GetMapping
    public List<Vinyle> getVinyles() {
        return vinyleService.getVinyles();
    }

    @GetMapping("/{idVinyle}")
    public Vinyle getVinyleById(@PathVariable long idVinyle) {
        return vinyleService.getVinyleById(idVinyle);
    }

    @PostMapping
    public Vinyle postVinyle(@RequestBody Vinyle vinyle) throws Exception {
        vinyleService.addVinyle(vinyle);
        return vinyle;
    }

    @PutMapping("/{idVinyle}")
    public Vinyle putFilm(@PathVariable Long idVinyle, @RequestBody Vinyle vinyle) {
        if (idVinyle != null) {
            vinyle.setId(idVinyle);
            vinyleService.updateVinyle(vinyle);
        }
        return vinyle;
    }

    @DeleteMapping("/{idVinyle}")
    public void deleteVinyle(@PathVariable Long idVinyle) {
        if (idVinyle != null) {
            vinyleService.deleteVinyleById(idVinyle);
        }
    }
}
