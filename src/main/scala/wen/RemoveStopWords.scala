package wen

import scala.io.Source

class RemoveStopWords {
  def loadDefaultStopWords: Array[String] = {
    Source.fromResource("english.txt").getLines().toArray
  }


  def RemoveStopWords(words: Array[String]) : Array[String] = {
    val StopWords = loadDefaultStopWords
    words.filter(s => !StopWords.contains(s))
  }

}

