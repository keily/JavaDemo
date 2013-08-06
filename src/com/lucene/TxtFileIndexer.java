package com.lucene;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.NumericField;
import org.apache.lucene.index.FieldInfo.IndexOptions;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.index.Term;
import org.apache.lucene.queryParser.MultiFieldQueryParser;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.util.Version;
import fx.sunjoy.*;
//import org.wltea.analyzer.lucene.IKAnalyzer;

public class TxtFileIndexer 
{
    public static final String indexPath = "D:\\dev\\java\\workspace\\LuceneTest4Console1\\indexfile";
    public static final Version VERSION_36 = Version.LUCENE_36;
    
    public static Analyzer analyzer = new StandardAnalyzer(VERSION_36);
    
    /**搜索结果排序方式(该字段索引时必须isIndexed=true)*/
    public static Sort sort = new Sort(new SortField("birth",SortField.INT,false));
    
    
    public static void index() throws Exception
    {
        Date start = new Date();
        System.out.println("Indexing to directory '" + indexPath + "'");
        
        Directory dir = FSDirectory.open(new File(indexPath));
        IndexWriterConfig iwc = new IndexWriterConfig(VERSION_36, analyzer);
        iwc.setOpenMode(OpenMode.CREATE);
//        iwc.setOpenMode(OpenMode.CREATE_OR_APPEND);
//        iwc.setRAMBufferSizeMB(1024.0);
        
        IndexWriter writer = new IndexWriter(dir, iwc);
        indexDocs(writer);
        writer.close();

        Date end = new Date();
        System.out.println(end.getTime() - start.getTime() + " total milliseconds");
    }
    
    
    public static void indexDocs(IndexWriter writer) throws IOException
    {
        for(String info:data)
        {
            String[] ss = info.split("\\|");
            Document doc = new Document();
            
            Field field_id = new Field("id", ss[0], Field.Store.YES, Field.Index.NOT_ANALYZED_NO_NORMS);
            field_id.setIndexOptions(IndexOptions.DOCS_ONLY);
            doc.add(field_id);
            
            Field field_name = new Field("name", ss[1], Field.Store.YES, Field.Index.ANALYZED);
            doc.add(field_name);
            
            NumericField field_birth = new NumericField("birth",Field.Store.YES, true);
            field_birth.setIntValue(Integer.valueOf(ss[2]));
            doc.add(field_birth);
            
            Field field_desc = new Field("desc", ss[3], Field.Store.YES, Field.Index.ANALYZED);
            doc.add(field_desc);
            
            if (writer.getConfig().getOpenMode() == OpenMode.CREATE) 
                writer.addDocument(doc);
            else
                writer.updateDocument(new Term("id", ss[0]), doc);
        }
    }
    
    
    
    public static void search(String[] fields,String keyword) throws Exception
    {
        /**获取IndexSearcher*/
        IndexReader reader = IndexReader.open(FSDirectory.open(new File(indexPath)));
        IndexSearcher searcher = new IndexSearcher(reader);
        
        /**搜索条件*/
//        QueryParser parser = new QueryParser(VERSION_36, fields[0], analyzer);
        QueryParser parser = new MultiFieldQueryParser(VERSION_36, fields, analyzer);
        Query query = parser.parse(keyword);
        System.out.println("Searching for: " + query.toString());
        
        TopDocs results = searcher.search(query, 5);
//        TopDocs results = searcher.search(query, 5, sort);
        ScoreDoc[] hits = results.scoreDocs;
        System.out.println("results.totalHits:"+ results.totalHits);
        System.out.println("hits.length:"+ hits.length);
        
        //高亮显示设置
//        Formatter formatter = new SimpleHTMLFormatter("<b>","</b>");   
//        Highlighter highlighter = new Highlighter(formatter,new QueryScorer(query));
//        highlighter.setTextFragmenter(new SimpleFragmenter(200));
        
        for(ScoreDoc scoreDoc:hits)
        {
            //评分详情
//            Explanation explanation = searcher.explain(query, scoreDoc.doc);
            
            Document doc= searcher.doc(scoreDoc.doc);
            System.out.println(scoreDoc.score + "\tid:"+doc.get("id")+"\tname:"+doc.get("name")+"\tbirth:"+doc.get("birth")+"\tdesc:"+doc.get("desc"));
//            System.out.println(scoreDoc.score + "  " + doc.toString());
            
//            TokenStream tokenStream = analyzer.tokenStream("token", new StringReader(doc.get(field)));
//            System.out.println(highlighter.getBestFragment(tokenStream,doc.get(field)));
        }
    }
    
    
    static String[] data = new String[]{
        
    };
    
    
}