package serviceTest;

import org.junit.Test;

import daoImpl.mock.TranscriptEntryImpl;

public class TranscriptEntyServiceTest {
	@Test
	public void tes() {
		// TODO Auto-generated method stub
		TranscriptEntryImpl tran=new TranscriptEntryImpl();
		System.out.println(tran.findAll().get(1).getGrade());

	}

}
