
package views.html

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/**/
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[String,Html,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title: String)(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.32*/("""

<!DOCTYPE html>
<html>
    <head>
        <title>"""),_display_(Seq[Any](/*6.17*/title)),format.raw/*6.22*/("""</title>
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*7.70*/routes/*7.76*/.Assets.at("stylesheets/bootstrap.min.css"))),format.raw/*7.119*/(""""> 
        <link rel="stylesheet" type="text/css" media="screen" href=""""),_display_(Seq[Any](/*8.70*/routes/*8.76*/.Assets.at("stylesheets/main.css"))),format.raw/*8.110*/(""""> 
        <script src=""""),_display_(Seq[Any](/*9.23*/routes/*9.29*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*9.74*/("""" type="text/javascript"></script>
        <script src=""""),_display_(Seq[Any](/*10.23*/routes/*10.29*/.Assets.at("javascripts/citeseer.js"))),format.raw/*10.66*/("""" type="text/javascript"></script>
    </head>
    <body>
        <center>
        <header class="topbar">
            <h1 class="fill">
                <a href=""""),_display_(Seq[Any](/*16.27*/routes/*16.33*/.Application.index())),format.raw/*16.53*/("""">
			        CitxtSeer			
                </a>
            </h1>
        </header>
		</center>
        
        <section id="main">
            """),_display_(Seq[Any](/*24.14*/content)),format.raw/*24.21*/("""
        </section>
        
    </body>
</html>"""))}
    }
    
    def render(title:String,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title)(content)
    
    def f:((String) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title) => (content) => apply(title)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Apr 24 21:06:46 EDT 2014
                    SOURCE: D:/citxtseer_v1/mainapp/app/views/main.scala.html
                    HASH: 9ada16c0c7e1effd09093e5133bf03805e7ea63c
                    MATRIX: 778->1|902->31|989->83|1015->88|1128->166|1142->172|1207->215|1315->288|1329->294|1385->328|1446->354|1460->360|1526->405|1619->462|1634->468|1693->505|1892->668|1907->674|1949->694|2131->840|2160->847
                    LINES: 26->1|29->1|34->6|34->6|35->7|35->7|35->7|36->8|36->8|36->8|37->9|37->9|37->9|38->10|38->10|38->10|44->16|44->16|44->16|52->24|52->24
                    -- GENERATED --
                */
            