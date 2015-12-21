
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
object noquery extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(Message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.19*/("""

"""),_display_(Seq[Any](/*3.2*/main("CitxtSeer")/*3.19*/ {_display_(Seq[Any](format.raw/*3.21*/("""

    <div id="actions">
        
        <form action="/papers" method="GET">
            <input type="search" id="searchbox" name="query" placeholder="Search by query..."> 
            <input type="submit" id="searchsubmit" value="Search" class="btn primary">
        </form>
                
    </div>

	<h1> """),_display_(Seq[Any](/*14.8*/Message)),format.raw/*14.15*/(""" </h1>
        
""")))})),format.raw/*16.2*/("""

            """))}
    }
    
    def render(Message:String): play.api.templates.HtmlFormat.Appendable = apply(Message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (Message) => apply(Message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Apr 24 21:06:46 EDT 2014
                    SOURCE: D:/citxtseer_v1/mainapp/app/views/noquery.scala.html
                    HASH: 57b10950abf0579be10586e422121f40d7d31a15
                    MATRIX: 776->1|887->18|926->23|951->40|990->42|1350->367|1379->374|1429->393
                    LINES: 26->1|29->1|31->3|31->3|31->3|42->14|42->14|44->16
                    -- GENERATED --
                */
            