package com.project.Controller;

import com.project.Models.Design.DesignCreationRequest;
import com.project.Models.Design.DesignDTO;
import com.project.Models.Design.DesignServiceImpl;
import com.project.Models.User.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/designs")
public class DesignController {
    private final DesignServiceImpl designService;

    public DesignController(DesignServiceImpl designService) {
        this.designService = designService;
    }

    @PostMapping
    public List<DesignDTO> getAllDesigns(@RequestBody Integer id){
        return designService.getAllDesigns(id);
    }

    @PostMapping("editor")
    public void createDesign(@RequestBody DesignCreationRequest request){
        designService.addDesign(request);
    }

    @DeleteMapping({"id"})
    public void deleteDesign(@PathVariable("id") Integer id){
        designService.removeDesign(id);
    }
}
