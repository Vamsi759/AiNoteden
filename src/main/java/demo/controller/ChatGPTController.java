package demo.controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.*;
// main url for if chat gpt token or credits are go to buying stage
// even utube url___https://youtu.be/wf3iohD43lk?si=zkXpAGOR4ItwpVaY
import demo.dto.PromptRequest;
import demo.service.ChatGPTService;


@CrossOrigin("*")
@RestController
@RequestMapping("/apap")
public class ChatGPTController {

    private final ChatGPTService chatGPTService;

    public ChatGPTController(ChatGPTService chatGPTService){
        this.chatGPTService = chatGPTService;
    }

    @PostMapping("/chat")
    public String chat(@RequestBody PromptRequest promptRequest){
         return chatGPTService.getChatResponse(promptRequest);
        /*return "In prompt mention key and then you gain response";*/
    }
    
// deno
    
}
