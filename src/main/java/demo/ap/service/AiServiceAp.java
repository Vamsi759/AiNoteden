package demo.ap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.ap.entity.Maintopic;
import demo.ap.entity.Subject;
import demo.ap.entity.Subtopic;
import demo.ap.repo.Maintopicrepo;
import demo.ap.repo.Subjectrepo;
import demo.ap.repo.Subtopicrepo;

@Service
public class AiServiceAp {

	ArrayList<ArrayList<ArrayList<Object>>> data = new ArrayList<>();

	// --------------------

	@Autowired
	Subjectrepo sr;

	@Autowired
	Maintopicrepo mr;

	@Autowired
	Subtopicrepo subr;

	public void save(Subject sv, Maintopic mv, Subtopic subv) {

		// ------------------------
		List<Integer>r=new ArrayList<>();

		List<Subject> slv = sr.findAll().stream().toList();
		List<Maintopic> mlv = mr.findAll().stream().toList();
		List<Subtopic> sublv = subr.findAll().stream().toList();

		for (int i = 0; i < slv.size(); i++) {

			if (slv.get(i).getSubjectname() != sv.getSubjectname()) {
				sr.save(sv);
				r.add(11);

			}else {
				r.add(10);
			}
		}

		for (int i = 0; i < mlv.size(); i++) {

			if (!mlv.get(i).getMaintopicname().equals(mv.getMaintopicname())) {
				mv.setSubjectname(sv.getSubjectname());
				mr.save(mv);
				r.add(21);
			}else {
				r.add(20);
			}
		}

		for (int i = 0; i < sublv.size(); i++) {

			if (!sublv.get(i).getSubtopicname().equals(subv.getSubtopicname())) {
				subv.setMaintopicname(mv.getMaintopicname());
				subr.save(subv);
				r.add(31);
			}else {
				r.add(30);
			}
		}
		
		//---------------
	}

}
