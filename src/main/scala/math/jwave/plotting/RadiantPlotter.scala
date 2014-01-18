package math.jwave.plotting

import math.jwave.transforms.wavelets.Wavelet

object RadiantPlotter {
  def plotForWavelet(w: Wavelet) = {
    val dataMap: Map[String, Seq[String]] = Map("x" -> w.scales.indices.map(_.toString), "scales" -> w.scales.map(_.toString), "coefficients" -> w.coefficients.map(_.toString))
    plotForDataset(w.toString.toLowerCase, dataMap)
  }

  def plotForDataset(datasetName: String, dataMap: Map[String, Seq[String]]): String = {
    def vectorReference(field: String) = s"[[${datasetName}.${field}]]"
    val yAxes = (dataMap.keySet - "x").toList.sorted
    val xml = (<plot height="300" aspect="3" stroke-width="2" title={ datasetName }  zoom-x="">
                 {
                   val colors = List("red", "green", "blue", "black")
                   yAxes.zipWithIndex.map {
                     case (f, i) =>
                       <lines x={ vectorReference("x") } y={ vectorReference(f) } stroke={ colors(i) }/>
                   }
                 }
               </plot>
               <plot-data name={ datasetName } format="csv" cols={ ("x" :: yAxes).mkString(",") }>
                 <metadata name="x" label="Index" units="d"></metadata>
                 {
                   yAxes.zipWithIndex.map {
                     case (f, i) =>
                       <metadata name={ f } label={ f }></metadata>
                   }
                 }
                 {
                   val cols: List[Seq[String]] = (dataMap("x") :: yAxes.map(dataMap))

                   cols.transpose.map(_.mkString(",")).mkString("\n")
                 }
               </plot-data>)
    xml.map(_.toString).mkString("\n")
  }

}