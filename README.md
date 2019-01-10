# Symptoms-Checker

#### For Apixio coding challenge:

Author: Wen Zhang

#### Summary: 

I have been thinking about creating a symptom checker application for a while. And this task happens to be aligned with my motivation. So I come up with this project with purpose to cluster diesease symptom information into different groups. The project will focus on online info retrieving, text preprocessing and a simple K Means modeling. The result of this project could provide insight for future disease classfication problems. 

#### Steps:

1. Retrieves symptom information of 11 different diseases from https://www.mayoclinic.org/. I particularly selected diseases form three categories: cancers, cardiovascular diseases, and neurological diseases. 
List of the urls of these diseases can be found [here](https://github.com/gogowenzhang/Symptoms-Checker/blob/master/src/main/resources/urls.csv). 

Example: symptoms of breast cancer
> A breast lump or thickening that feels different from the surrounding tissue
> Change in the size, shape or appearance of a breast
> Changes to the skin over the breast, such as dimpling
> A newly inverted nipple
> Peeling, scaling, crusting or flaking of the pigmented area of skin surrounding the nipple (areola) or breast skin
> Redness or pitting of the skin over your breast, like the skin of an orange

2. Preprocessing:
  * Tokenize: to split sentence into array of words. 
  
  * Lemmatize: to convert the word into the base or dictionary form. Uses the [WordNet](https://wordnet.princeton.edu/) dictionary. 
  
  * Remove stop words: to remove stop words using NLTK's list. The list can be found [here](https://github.com/gogowenzhang/Symptoms-Checker/blob/master/src/main/resources/english.txt)
  
  * Vectorize: to maps a sequence of words to their term frequencies using the hashing trick.  
    Based on source:  https://en.wikipedia.org/wiki/Feature_hashing   
    Hashing function: https://docs.oracle.com/javase/7/docs/api/java/lang/String.html#hashCode()

3. Modeling:   
 Implemented a simple K-Means Clutersing model. Applied tail recursion to iterate the reassignment of labels and recalculating centroids. 


#### Results: 
| Disease                         | Category          | Cluster Label  |
| ------------------------------- |:-----------------:|:--------------:| 
| breast-cancer                   | cancer            | 2              |
| colon-cancer                    | cancer            | 2              |
| rectal-cancer                   | cancer            | 2              |
| lung-cancer                     | cancer            | 0              |
| adult-congenital-heart-disease  | cardiovascular    | 0              |
| heart-arrhythmia                | cardiovascular    | 0              |
| hypertrophic-cardiomyopathy     | cardiovascular    | 0              |
| brain-aneurysm                  | neurology         | 1              |
| glioma                          | neurology         | 1              |
| epilepsy                        | neurology         | 2              |
| dural-arteriovenous-fistulas    | neurology         | 1              |


#### Error Analysis:
There are two diseases have been mistakenly clustered: lung cancer and epilepsy. 

Symptoms of lung cancer involves shortness of breath and chest pain, which are very common signs of cardiology problems. While its distinguishable symptoms like coughing and coughing in blood will not help to be categoried into cancer group. This error is probrobaly not due to the model at this moment. 







