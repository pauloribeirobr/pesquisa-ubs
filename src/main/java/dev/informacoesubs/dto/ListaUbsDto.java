package dev.informacoesubs.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

public class ListaUbsDto {

	@JsonAlias("current_page")
	private int currentPage;
	@JsonAlias("per_page")
	private int perPage;
	@JsonAlias("total_entries")
	private int totalEntries;
	private List<UbsDto> entries;
	
	public ListaUbsDto() {
		this.currentPage = 0;
		this.perPage = 0;
		this.totalEntries = 0;
		this.entries = new ArrayList<UbsDto>();
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getTotalEntries() {
		return totalEntries;
	}

	public void setTotalEntries(int totalEntries) {
		this.totalEntries = totalEntries;
	}

	public List<UbsDto> getEntries() {
		return entries;
	}

	public void setEntries(List<UbsDto> entries) {
		this.entries = entries;
	}
}
