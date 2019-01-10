package wen

/**
  * Lemmatize
  * To convert the word into the base or dictionary form.
  * Uses the WordNet Database
  * Returns the input word unchanged if it cannot be found in WordNet.
  */

class Lemmatizer extends WordNet {
  def lemmatize(word: String): String = {
    val lemma = morphy(word)
    if (lemma.isEmpty) word
    else lemma}
}


