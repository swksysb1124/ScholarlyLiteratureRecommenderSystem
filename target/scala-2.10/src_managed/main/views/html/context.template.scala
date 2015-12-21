
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
object context extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template2[List[Paper],List[Context],play.api.templates.HtmlFormat.Appendable] {

    /**/
    def apply/*1.2*/(papers:List[Paper],contexts:List[Context]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*1.45*/("""

"""),_display_(Seq[Any](/*3.2*/main("CitxtSeer")/*3.19*/ {_display_(Seq[Any](format.raw/*3.21*/("""
    
    """),_display_(Seq[Any](/*5.6*/if(flash.containsKey("success"))/*5.38*/ {_display_(Seq[Any](format.raw/*5.40*/("""
        <div class="alert-message warning">
            <strong>Done!</strong> """),_display_(Seq[Any](/*7.37*/flash/*7.42*/.get("success"))),format.raw/*7.57*/("""
        </div>
    """)))})),format.raw/*9.6*/(""" 
	
    <div id="actions">
        <form action="/papers" method="GET"> 
            <input type="search" id="searchbox" name="query" placeholder="Search by query..."> 
            <input type="submit" id="searchsubmit" value="Search" class="btn primary">
        </form>   	
    </div>
	
	
	 """),_display_(Seq[Any](/*19.4*/for(paper <- papers) yield /*19.24*/ {_display_(Seq[Any](format.raw/*19.26*/("""
						<center><h2>"""),_display_(Seq[Any](/*20.20*/paper/*20.25*/.title)),format.raw/*20.31*/("""</h2>
						<div class="pubinfo">
							<p><span class="authors">  by """),_display_(Seq[Any](/*22.39*/paper/*22.44*/.authors)),format.raw/*22.52*/(""" </span></h5> 
							"""),_display_(Seq[Any](/*23.9*/if(paper.pubvenue !=null)/*23.34*/{_display_(Seq[Any](format.raw/*23.35*/("""
								<p><span class="pubvenue"><strong> Venue:</strong> """),_display_(Seq[Any](/*24.61*/paper/*24.66*/.pubvenue)),format.raw/*24.75*/("""</span></h5>
							""")))})),format.raw/*25.9*/("""
							"""),_display_(Seq[Any](/*26.9*/if(paper.year !=null)/*26.30*/{_display_(Seq[Any](format.raw/*26.31*/("""							
								<p><span class="pubyear"><strong> Published:</strong> """),_display_(Seq[Any](/*27.64*/paper/*27.69*/.year)),format.raw/*27.74*/("""</span></h5> 
							""")))})),format.raw/*28.9*/("""
						</div></center>
						<br>
						<div> 
							<center> <h3> Abstract </h3> </center>
							<div> <p> """),_display_(Seq[Any](/*33.19*/paper/*33.24*/.abst)),format.raw/*33.29*/(""" </p> </div>
						</div>					
                """)))})),format.raw/*35.18*/("""
		
    <!-- 以下是search engine 結果呈現方式 -->
    """),_display_(Seq[Any](/*38.6*/if(contexts.size() == 0)/*38.30*/ {_display_(Seq[Any](format.raw/*38.32*/("""
			<div class="well">
				<em>Nothing to display</em>
			</div>
    """)))}/*42.7*/else/*42.12*/{_display_(Seq[Any](format.raw/*42.13*/("""
				<!-- 將currentPage.getList 所產出的 Computer List 列出 , 我們的case是 paper list。將List資料存成computer物件 -->
				<!--
				<center><h3>Citation List</h3></center>
                <ol>
				"""),_display_(Seq[Any](/*47.6*/for(context <- contexts) yield /*47.30*/{_display_(Seq[Any](format.raw/*47.31*/("""
				<li>"""),_display_(Seq[Any](/*48.10*/context/*48.17*/.title)),format.raw/*48.23*/("""   		
                """)))})),format.raw/*49.18*/("""
				</ol>
				<br><br>
				-->
				<br>
				<center><h3>Citation Contexts</h3></center>
				<ol>
					"""),_display_(Seq[Any](/*56.7*/for(context <- contexts) yield /*56.31*/ {_display_(Seq[Any](format.raw/*56.33*/("""
						"""),_display_(Seq[Any](/*57.8*/if(context.unCutCtxt !=null)/*57.36*/{_display_(Seq[Any](format.raw/*57.37*/("""
							<p> <li>"""),_display_(Seq[Any](/*58.17*/context/*58.24*/.Ctxt_upperparg)),format.raw/*58.39*/(""" <strong> <font color="31849B">"""),_display_(Seq[Any](/*58.71*/context/*58.78*/.Ctxt_number)),format.raw/*58.90*/("""</font></strong>  """),_display_(Seq[Any](/*58.109*/context/*58.116*/.Ctxt_lowerparg)),format.raw/*58.131*/("""
							</P>
						""")))})),format.raw/*60.8*/("""	
					""")))})),format.raw/*61.7*/("""
				</ol>
				<!--
				<br><br>
				<center><h3>Original:Citation Contexts</h3></center>
				<ol>
					"""),_display_(Seq[Any](/*67.7*/for(context <- contexts) yield /*67.31*/ {_display_(Seq[Any](format.raw/*67.33*/("""
						<p> <li>"""),_display_(Seq[Any](/*68.16*/context/*68.23*/.unCutCtxt)),format.raw/*68.33*/("""	</P>
					""")))})),format.raw/*69.7*/("""
				</ol>
				-->
			""")))})),format.raw/*72.5*/("""	
			
            </tbody>
        
""")))})),format.raw/*76.2*/("""

            """))}
    }
    
    def render(papers:List[Paper],contexts:List[Context]): play.api.templates.HtmlFormat.Appendable = apply(papers,contexts)
    
    def f:((List[Paper],List[Context]) => play.api.templates.HtmlFormat.Appendable) = (papers,contexts) => apply(papers,contexts)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Apr 24 21:06:46 EDT 2014
                    SOURCE: D:/citxtseer_v1/mainapp/app/views/context.scala.html
                    HASH: 0a26fbd62ed4a249179e3bad5fa3f6d5a0f2c9c7
                    MATRIX: 795->1|932->44|971->49|996->66|1035->68|1082->81|1122->113|1161->115|1279->198|1292->203|1328->218|1381->241|1720->545|1756->565|1796->567|1853->588|1867->593|1895->599|2005->673|2019->678|2049->686|2108->710|2142->735|2181->736|2279->798|2293->803|2324->812|2377->834|2422->844|2452->865|2491->866|2599->938|2613->943|2640->948|2694->971|2846->1087|2860->1092|2887->1097|2969->1147|3053->1196|3086->1220|3126->1222|3218->1297|3231->1302|3270->1303|3488->1486|3528->1510|3567->1511|3614->1522|3630->1529|3658->1535|3714->1559|3860->1670|3900->1694|3940->1696|3984->1705|4021->1733|4060->1734|4114->1752|4130->1759|4167->1774|4235->1806|4251->1813|4285->1825|4341->1844|4358->1851|4396->1866|4449->1888|4489->1897|4635->2008|4675->2032|4715->2034|4768->2051|4784->2058|4816->2068|4860->2081|4917->2107|4989->2148
                    LINES: 26->1|29->1|31->3|31->3|31->3|33->5|33->5|33->5|35->7|35->7|35->7|37->9|47->19|47->19|47->19|48->20|48->20|48->20|50->22|50->22|50->22|51->23|51->23|51->23|52->24|52->24|52->24|53->25|54->26|54->26|54->26|55->27|55->27|55->27|56->28|61->33|61->33|61->33|63->35|66->38|66->38|66->38|70->42|70->42|70->42|75->47|75->47|75->47|76->48|76->48|76->48|77->49|84->56|84->56|84->56|85->57|85->57|85->57|86->58|86->58|86->58|86->58|86->58|86->58|86->58|86->58|86->58|88->60|89->61|95->67|95->67|95->67|96->68|96->68|96->68|97->69|100->72|104->76
                    -- GENERATED --
                */
            