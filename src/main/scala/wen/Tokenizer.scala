package wen


class Tokenizer {
  /**
    * myLowerCase
    * To convert to lowercase except for acronyms.
    * @param word
    * @return lowercaseword
    */
  def myLowerCase(word: String): String = {
    if (word.matches("\\b(?:[A-Z]\\.*){2,}\\b")) word
    else word.toLowerCase()
  }

  /** Tokenize
    * To split the sentence by white spaces and remove punctuation.
    */
  def tokenize(sentence: String): Array[String] = {
    val words = sentence.trim.split("\\s+")
    val tokens = words.map(_.replaceAll("[(),!.]", "").trim())
    tokens.map(myLowerCase)
  }
}
