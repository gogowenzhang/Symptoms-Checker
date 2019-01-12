package wen

import scala.io.Source


object main extends App {
  // To retrieve contents
  val rt = new Retriever
  val readmeText : Iterator[String] = Source.fromResource("urls.csv").getLines
  val content_list = readmeText.map(rt.getSymptomfromURL).toList

  val sentences = content_list.map(_.split("/n").toSeq)

  // To split sentence into words
  val tk = new Tokenizer
  val tokens = sentences.map(x => x.map(tk.tokenize))

  // To convert word into base form
  val lm = new Lemmatizer
  val lemmas = tokens.map(x => x.map(x => x.map(lm.lemmatize)))

  // To remove stop words
  val sw = new RemoveStopWords
  val lemmas_sw = lemmas.map(x => x.map(sw.RemoveStopWords))

  val terms_list = lemmas_sw.map(_.flatten)

  // To vectorize terms using hashing tricks
  val hf = new HashingTF
  val vectors = terms_list.map(x => hf.HashingTF(x, 5000))

  // To apply K-Means modeling to data
  val km = new KMeans
  val labels = km.train(vectors, 3, 100)

  println(labels)
}






