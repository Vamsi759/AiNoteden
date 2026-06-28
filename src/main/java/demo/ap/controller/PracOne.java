package demo.ap.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import demo.ap.entity.Maincut;
import demo.ap.entity.Maintopic;
import demo.ap.entity.Recorddemo;
import demo.ap.repo.Recorddemorepo;
@CrossOrigin("*")
@RestController
@RequestMapping("/apirl")
public class PracOne {

	@Autowired
	Recorddemorepo rp;

	@GetMapping("/message")
	public Map<String, String> testone() {

		Map<String, String> map = new HashMap<>();
		map.put("message", "Hello from Backend");
		return map;
	}
	

	@PostMapping("/del")
	public String remove(@RequestBody Recorddemo m) {
		System.out.println("del run");
		List<Recorddemo>ap=rp.findAll().stream().toList();
		
		for(int i=0;i<ap.size();i++) {
			Recorddemo r=ap.get(i);
			if(r.getSubjectname().equals(m.getSubjectname()) && r.getMaintopicname().equals(m.getMaintopicname()) && r.getSubtopicname().equals(m.getSubtopicname()) 
					) {
				
				rp.deleteById(r.getId());
				
			}
		}
		return "deleted";
		
		
		
	}
	
	
	
	@PostMapping("/callnormalcut")
	public String callmaincutcut(@RequestBody Recorddemo  m) {
		rp.save(m);
	
		return "den";
	}
	

	@PostMapping("/callmaincut")
	public String callmaincut(@RequestBody Maincut m) {
		
		String s;
		String den;
		String ms = "", me = "";
		
		
		ms = m.getMainstart();
		me = m.getMainend();
		s = m.getResult();
		
		s=s+" dendenkittukittu";
		//System.out.println(ms.substring(2,3));
		
for(int i=0;i<s.length();i++) {
		//	System.out.print("("+s.charAt(i)+""+i+") ");
			System.out.print("("+s.charAt(i)+""+i+") "+(s.charAt(i)+1)+" ");
		}

        int si=-1;
        
        for(int i=0;i<s.length();i++){
        	
        String ap="";
        
        if((i+ms.length())<s.length()) {
        	
        ap=s.substring(i,i+ms.length());
        
       
        
        if(ms.equals(ap) && si<0){
        si=i; 
        System.out.println(ap+"kittuuu"+""+si);
        break;
        }
          
        }
        
        
        }
        System.out.println(si+" "+(s.length()-1));
        
        
         int ei=-1;
        for(int i=0;i<s.length();i++){
        String ap="";
        if((i+me.length())<s.length())
        ap=s.substring(i,i+me.length());
        // System.out.println(me+"__"+ap);
        if(me.equals(ap) && ei<i){
        ei=i;
        
        System.out.println(me+"__"+ap+""+ei);
        }
        }
        
      //  System.out.println(s.substring(3,ei)+""+s.substring(ei,ei+me.length()));
        
        System.out.println(ei+" "+(s.length()-1));
        return  s.substring(si,ei)+""+s.substring(ei,ei+me.length());
        //System.out.println();
        


		//n s.substring(si, se) + s.substring(se+1, se+1+me.length()-1);

	}

	@GetMapping("rl")
	public LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, String>>> datatake() {

		LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, String>>> den = new LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, String>>>();


		// -------------------
		// -------------------
		// Taking data from db

		List<Recorddemo> l = rp.findAll().stream().toList();

		// den

		for (int i = 0; i < l.size(); i++) {

			Recorddemo r = l.get(i);

			// --------------------------------
			if (!den.containsKey(r.getSubjectname())) {

				LinkedHashMap<String, LinkedHashMap<String, String>> d2 = new LinkedHashMap<String, LinkedHashMap<String, String>>();
				LinkedHashMap<String, String> d3 = new LinkedHashMap<String, String>();

				if (!d2.containsKey(r.getMaintopicname())) {

					if (!d3.containsKey(r.getSubtopicname())) {
						d3.put(r.getSubtopicname(), r.getTheory());
					}

					d2.put(r.getMaintopicname(), d3);
					den.put(r.getSubjectname(), d2);

				} else {
					d3 = d2.get(r.getMaintopicname()); // d2 map
					d3.put(r.getSubtopicname(), r.getTheory());

				}

			} // -----------------------------------
			else {
				LinkedHashMap<String, LinkedHashMap<String, String>> d2 = den.get(r.getSubjectname());

				LinkedHashMap<String, String> d3 = new LinkedHashMap<String, String>();

				if (!d2.containsKey(r.getMaintopicname())) {

					if (!d3.containsKey(r.getSubtopicname())) {
						d3.put(r.getSubtopicname(), r.getTheory());
					}

					d2.put(r.getMaintopicname(), d3);

				} else {
					d3 = d2.get(r.getMaintopicname()); // d2 map
					d3.put(r.getSubtopicname(), r.getTheory());

				}

			}

		}
		return den;

	}

}
