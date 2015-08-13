package lbi.iq.usp.br.mgbl.mgbl.config;

public class TaxonomyFileConfig {
	private String provider;
	private String taxonomy;
	
	public TaxonomyFileConfig(String provider, String taxonomy) {
		this.taxonomy = taxonomy;
		this.provider = provider;
	}
	
	public String getProviderName(){
		return provider;
	}
	
	public String getTaxonomyFilePath(){
		return taxonomy;
	}
	
	
}
