package com.project.Controller;

import com.project.Models.Design.DesignCreationRequest;
import com.project.Models.Design.DesignDTO;
import com.project.Models.Design.DesignServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/designs")
public class DesignController {
    private final DesignServiceImpl designService;

    public DesignController(DesignServiceImpl designService) {
        this.designService = designService;
    }

    @GetMapping
    public List<DesignDTO> getAllDesigns(){
        return designService.getAllDesigns();
    }

    @GetMapping({"id"})
    public DesignDTO getDesign(@PathVariable("id") Integer id){
        return designService.getDesignById(id);
    }

    @PostMapping()
    public void createDesign(@RequestBody DesignCreationRequest request){
        designService.addDesign(request);
    }

    @DeleteMapping({"id"})
    public void deleteDesign(@PathVariable("id") Integer id){
        designService.removeDesign(id);
    }
}
