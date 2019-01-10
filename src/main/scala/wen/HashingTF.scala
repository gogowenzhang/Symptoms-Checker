package wen

class HashingTF {
  /** To maps a sequence of words to their term frequencies using the hashing trick.
    * Uses java.String.hashCode to calculate the hash code value for the term object.
    */

  def HashingTF(words: Seq[String], numFeatures: Int): List[Double] = {
    // Initiate an array with zeros
    val SparseVector = Array.fill[Double](numFeatures)(0.0)

    // Map word to number feature by [word.hashCode mod numFeatures]
    // Based on source:  https://en.wikipedia.org/wiki/Feature_hashing
    // Hashing function: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#hashCode()
    val features = words.map(x => Math.abs(x.hashCode()) % numFeatures)

    // Count the frequencies
    for (feature <- features) SparseVector(feature) += 1.0

    SparseVector.toList
  }

}

