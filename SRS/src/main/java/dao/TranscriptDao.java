package dao;

import java.util.HashMap;

import model.Transcript;
import model.TranscriptEntry;

public interface TranscriptDao {
	public Transcript getTranscript();
	public HashMap<String,TranscriptEntry> findAllTranscriptEntriesBySection();
	public HashMap<String, TranscriptEntry> findAllTranscriptEntriesByStudent();

}
