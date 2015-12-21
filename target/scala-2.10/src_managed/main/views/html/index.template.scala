
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
object index extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(title :String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.17*/(""" <!--輸入的參數   參數名稱 : 參數類型 -->

"""),_display_(Seq[Any](/*3.2*/main(title)/*3.13*/ {_display_(Seq[Any](format.raw/*3.15*/("""

	<center>	
	<div id="search_box">	<!-- -->
		<div id="search_basic">  <!-- -->
			<h3>Citation Context System</h3> <!-- -->
			<form action="/papers" method="GET"> <!-- -->
				<textarea name="query" rows="3" cols="70"></textarea> <!-- -->
				<p> <!-- -->
				<input type="submit" value="Search" class="btn primary"> <!-- -->
				</p> <!-- -->
			</form><!-- -->
			<br /><br /><br /> <!-- -->
		</div>				
	</div>
	</center>	
""")))})),format.raw/*19.2*/("""
"""))}
    }
    
    def render(title:String): play.api.templates.HtmlFormat.Appendable = apply(title)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (title) => apply(title)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Apr 24 21:06:46 EDT 2014
                    SOURCE: D:/citxtseer_v1/mainapp/app/views/index.scala.html
                    HASH: b695cd18ea67f33afcd19ea4905e53fe26311461
                    MATRIX: 774->1|883->16|948->47|967->58|1006->60|1468->491
                    LINES: 26->1|29->1|31->3|31->3|31->3|47->19
                    -- GENERATED --
                */
            