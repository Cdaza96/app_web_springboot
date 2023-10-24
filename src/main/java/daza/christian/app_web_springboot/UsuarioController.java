/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daza.christian.app_web_springboot;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Andres
 */

@Controller
public class UsuarioController {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private TareaRepository tareaRepository;
    
    @GetMapping("")
    public String index(Model model){
        List<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);

        List<Tarea> tareas = tareaRepository.findAll();
        model.addAttribute("tareas", tareas);
        return "index";
    }
    
    @GetMapping("/nuevo")
    public String nuevo(Model model){
        model.addAttribute("usuario", new Usuario());
        return "nuevo";
    }
    @PostMapping("/nuevo")
    public String crear(Usuario usuario){
        usuarioRepository.save(usuario);
        return "redirect:/";
    }

    //controlador de tareas


    @GetMapping("/nueva-tarea")
    public String nuevaTarea(Model model){
        model.addAttribute("tarea", new Tarea());
        return "nueva-tarea";
    }

    @PostMapping("/nueva-tarea")
    public String crearTarea(Tarea tarea){
        tareaRepository.save(tarea);
        return "redirect:/";
    }
    
}

