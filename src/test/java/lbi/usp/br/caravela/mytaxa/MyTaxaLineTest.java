package lbi.usp.br.caravela.mytaxa;

import static org.junit.Assert.*;

public class MyTaxaLineTest {

	private static final String SEQUENCE_REFERENCE = "M01677:6:000000000-A41BV:1:1101:17611:1840 1:N:0:8";
	private static final String TAXONOMY_RANK_SPECIE = "Species";
	private static final String SCORE = "1";
	private static final String TAXONOMY_RANK_GENUS = "Genus";
	private static final String TAXONOMY_ID = "28118";
	private static final String LINEAGE_SPECIES = "<superkingdom>Bacteria;<superphylum>Bacteroidetes/Chlorobi group;<phylum>Bacteroidetes;<class>Bacteroidia;<order>Bacteroidales;<family>Porphyromonadaceae;<genus>Odoribacter;<species>Odoribacter splanchnicus";
	private static final String LINEAGE_GENUS = "<superkingdom>Bacteria;<phylum>Proteobacteria;<subphylum>delta/epsilon subdivisions;<class>Epsilonproteobacteria;<order>Campylobacterales;<family>Campylobacteraceae;<genus>Arcobacter";

	public void testGetters() {
		MyTaxaLine myTaxaLine = new MyTaxaLine(SEQUENCE_REFERENCE, TAXONOMY_RANK_SPECIE, TAXONOMY_ID, SCORE,
				LINEAGE_SPECIES);

		assertEquals(myTaxaLine.getSequenceReference(), SEQUENCE_REFERENCE);
		assertEquals(myTaxaLine.getTaxonomyRank(), TAXONOMY_RANK_SPECIE);
		assertEquals(myTaxaLine.getTaxonomyId(), TAXONOMY_ID);
		assertEquals(myTaxaLine.getLineage(), LINEAGE_SPECIES);

	}

	public void testGetDeepestTaxonomyWhenTaxonomyDeepIsSpecie() throws Exception {
		MyTaxaLine myTaxaLine = new MyTaxaLine(SEQUENCE_REFERENCE, TAXONOMY_RANK_SPECIE, TAXONOMY_ID, SCORE,
				LINEAGE_SPECIES);
		String deepestTaxonomy = myTaxaLine.getDeepestTaxonomy();
		assertEquals(deepestTaxonomy, "<species>Odoribacter splanchnicus");
	}

	public void testGetDeepestTaxonomyWhenTaxonomyDeepIsGenus() throws Exception {
		MyTaxaLine myTaxaLine = new MyTaxaLine(SEQUENCE_REFERENCE, TAXONOMY_RANK_GENUS, TAXONOMY_ID, SCORE,
				LINEAGE_GENUS);
		String deepestTaxonomy = myTaxaLine.getDeepestTaxonomy();
		assertEquals(deepestTaxonomy, "<genus>Arcobacter");
	}

	public void testGetDeepestTaxonomyWhenHasNoLineage() throws Exception {
		MyTaxaLine myTaxaLine = new MyTaxaLine(SEQUENCE_REFERENCE, TAXONOMY_RANK_SPECIE, TAXONOMY_ID, SCORE, null);
		String deepestTaxonomy = myTaxaLine.getDeepestTaxonomy();
		assertEquals(deepestTaxonomy, "NA");
	}
}