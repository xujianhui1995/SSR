package dao;

import java.util.ArrayList;
import java.util.HashMap;

import model.TranscriptEntry;

public interface TranscriptEntryDao {
	public ArrayList<TranscriptEntry> findAll();
	public HashMap<String,TranscriptEntry> findAllTranscriptEntriesBySection();
	HashMap<String, TranscriptEntry> findAllTranscriptEntriesByStudent();

}
