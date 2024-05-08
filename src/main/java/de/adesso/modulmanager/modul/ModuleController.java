package de.adesso.modulmanager.modul;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RestController
@RequestMapping("api/v1/module")
public class ModuleController {

  @Autowired
  ModuleService moduleService;

  // Create a new Module and save it to the DB.
  @PostMapping("post")
  public String createModule(@RequestBody Module module) {
    return moduleService.createModule(module);
  }

  // Get a Module in the DB by it's Id.
  @GetMapping("{moduleId}")
  public Module getModule(@PathVariable int moduleId) {
    return moduleService.getModule(moduleId);
  }

  @PostMapping("calculateCp")
  public Integer calculateCp(@RequestBody List<Integer> cPList) {
      return moduleService.calculateCp(cPList);
  }
  

  // Get every Module in the DB.
  @GetMapping("getAll")
  public List<Module> showAll() {
    return moduleService.getAllModules();
  }

  // Update a Module in the DB.
  @PutMapping("put")
  public Module updateStudent(@RequestBody Module module) {
    return moduleService.updateModule(module);
  }

  // Delete a Module from the DB.
  @DeleteMapping("delete/{moduleId}")
  public String deleteModule(@PathVariable int moduleId) {
    return moduleService.deleteModule(moduleId);
  }

  @GetMapping("checkForModule/{moduleId}")
  public boolean checkForModule(@PathVariable Integer moduleId) {
    return moduleService.checkForModule(moduleId);
  }

}
