package serviceTest;

import org.junit.Test;

import action.TranscriptAction;

public class TranscriptEntyServiceTest {

	@Test
	public void getall() {
		// TODO Auto-generated method stub
		// TranscriptDaoImpl TranscriptDaoImpl = new TranscriptDaoImpl();
		// Transcript t = TranscriptDaoImpl.getTranscript();
		// TranscriptService ts=new
		// TranscriptService(DaoFactory.createTranscriptDao());
		// List<TranscriptEntry> list = new ArrayList<TranscriptEntry>();
		// list = t.getTranscriptEntries();
		//
		// Gson gson = new Gson();
		// String s = gson.toJson(list);
		// System.out.println(s);
		TranscriptAction t=new TranscriptAction();
		t.getTranscript();
	}

}
