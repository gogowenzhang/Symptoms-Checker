package wen

import java.io.FileInputStream

import net.didion.jwnl.JWNL
import net.didion.jwnl.data.POS
import net.didion.jwnl.dictionary.Dictionary

import scala.collection.JavaConversions._

/** Wordnet
  * Based on original source: http://sujitpal.blogspot.com/2014/04/nltk-like-wordnet-interface-in-scala.html
  * Looks up possible base form (lemma) in WordNet using JMWL.
  */

class WordNet {
  JWNL.initialize(new FileInputStream("/Users/wen/code/scala/apixio/src/main/resources/wnconfig.xml"))
  val dict = Dictionary.getInstance()

  def morphy(word: String, pos: POS): String = {
    val bf = dict.getMorphologicalProcessor()
      .lookupBaseForm(pos, word)
    if (bf == null) "" else bf.getLemma()
  }

  def morphy(word: String): String = {
    val bases = POS.getAllPOS().map(pos =>
      morphy(word, pos.asInstanceOf[POS]))
      .filter(str => (!str.isEmpty()))
      .toSet
    if (bases.isEmpty) "" else bases.toList.head
  }

}





