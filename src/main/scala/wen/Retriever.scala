package wen

import org.jsoup.Jsoup

class Retriever {

  /**
    * To retrieve symptom information from https://www.mayoclinic.org/
    * Return contents as a string.
    * @param url
    * @return
    */
  def getSymptomfromURL(url: String): String = {
    val doc = Jsoup.connect(url).get
    val content = doc.getElementsByClass("content").get(0)
    val content_div = content.child(1)

    val symptom = content_div.select("h2:contains(Symptoms)").get(0)
    val start_index = symptom.elementSiblingIndex()
    val ul = content_div.select(s"ul:gt($start_index)").get(0)
    val li = ul.select("li")

    for (i <- 0 until li.size()-1)
      li.get(i).appendText("/n")

    li.text()
  }

}
