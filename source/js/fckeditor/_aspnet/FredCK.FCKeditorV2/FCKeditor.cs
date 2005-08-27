/*
 * FCKeditor - The text editor for internet
 * Copyright (C) 2003-2004 Frederico Caldeira Knabben
 * 
 * Licensed under the terms of the GNU Lesser General Public License:
 * 		http://www.opensource.org/licenses/lgpl-license.php
 * 
 * For further information visit:
 * 		http://www.fckeditor.net/
 * 
 * File Name: FCKeditor.cs
 * 	This is the FCKeditor Asp.Net control.
 * 
 * Version:  2.0 Beta 2
 * Modified: 2004-05-31 23:17:23
 * 
 * File Authors:
 * 		Frederico Caldeira Knabben (fredck@fckeditor.net)
 */

using System ;
using System.Web.UI ;
using System.Web.UI.WebControls ;
using System.ComponentModel ;
using System.Text.RegularExpressions ;
using System.Globalization ;
using System.Security.Permissions ;

namespace FredCK.FCKeditorV2
{
//	[ System.Web.AspNetHostingPermission(SecurityAction.LinkDemand) ]
	[ DefaultProperty("Value") ]
	[ ValidationProperty("Value") ]
	[ ToolboxData("<{0}:FCKeditor runat=server></{0}:FCKeditor>") ]
	[ Designer("FredCK.FCKeditorV2.FCKeditorDesigner") ]
	[ ParseChildren(false) ]
	public class FCKeditor : System.Web.UI.Control, IPostBackDataHandler
	{
		private FCKeditorConfigurations oConfig ;

		public FCKeditor()
		{
			oConfig = new FCKeditorConfigurations() ;
		}

		[ Browsable( false ) ]
		public FCKeditorConfigurations Config
		{
			get { return oConfig ; }
		}

		[ DefaultValue( "" ) ]
		public string Value
		{
			get { return (string)IsNull( ViewState["Value"], "" ) ; }
			set { ViewState["Value"] = value ; }
		}

		[ DefaultValue( "/FCKeditor/" ) ]
		public string BasePath
		{
			get { return (string)IsNull( ViewState["BasePath"], "" ) ; }
			set { ViewState["BasePath"] = value ; }
		}

		[ DefaultValue( "Default" ) ]
		public string ToolbarSet
		{
			get { return (string)IsNull( ViewState["ToolbarSet"], "Default" ) ; }
			set { ViewState["ToolbarSet"] = value ; }
		}

		[ Category( "Appearence" ) ]
		[ DefaultValue( "100%" ) ]
		public Unit Width
		{
			get { return (Unit)IsNull( ViewState["Width"], Unit.Parse("100%", CultureInfo.InvariantCulture) ) ; }
			set { ViewState["Width"] = value ; }
		}

		[ Category("Appearence") ]
		[ DefaultValue( "200px" ) ]
		public Unit Height
		{
			get { return (Unit)IsNull( ViewState["Height"], Unit.Parse("200px", CultureInfo.InvariantCulture) ) ; }
			set { ViewState["Height"] = value ; }
		}

		public bool LoadPostData(string postDataKey, System.Collections.Specialized.NameValueCollection postCollection)
		{
			if (postCollection[postDataKey] != Value)
			{
				Value = postCollection[postDataKey];
				return true;
			}
			return false;
		}

		public bool CheckBrowserCompatibility()
		{
			System.Web.HttpBrowserCapabilities oBrowser = Page.Request.Browser ;

			// Internet Explorer 5.5+ for Windows
			if (oBrowser.Browser == "IE" && ( oBrowser.MajorVersion >= 6 || ( oBrowser.MajorVersion == 5 && oBrowser.MinorVersion >= 5 ) ) && oBrowser.Win32)
				return true ;
			else
			{
				Match oMatch = Regex.Match( this.Page.Request.UserAgent, @"(?<=Gecko/)\d{8}" ) ;
				return ( oMatch.Success && int.Parse( oMatch.Value, CultureInfo.InvariantCulture ) >= 20030210 ) ;
			}
		}

		protected override void Render(HtmlTextWriter writer)
		{
			writer.Write( "<div>" ) ;

			if ( this.CheckBrowserCompatibility() )
			{
				string sLink = this.BasePath + "editor/fckeditor.html?InstanceName=" + this.UniqueID ;
				if ( this.ToolbarSet.Length > 0 ) sLink += "&Toolbar=" + this.ToolbarSet ;

				// Render the linked hidden field.
				writer.Write( 
					"<input type=\"hidden\" id=\"{0}\" name=\"{0}\" value=\"{1}\">",
						this.UniqueID,
						System.Web.HttpUtility.HtmlEncode( this.Value ) ) ;

				// Render the configurations hidden field.
				writer.Write( 
					"<input type=\"hidden\" id=\"{0}___Config\" value=\"{1}\">",
						this.UniqueID,
						this.Config.GetHiddenFieldString() ) ;

				// Render the editor IFRAME.
				writer.Write(
					"<iframe id=\"{0}___Frame\" src=\"{1}\" width=\"{2}\" height=\"{3}\" frameborder=\"no\" scrolling=\"no\"></iframe>",
						this.UniqueID,
						sLink,
						this.Width,
						this.Height ) ;
			}
			else
			{
				writer.Write(
					"<textarea name=\"{0}\" rows=\"4\" cols=\"40\" style=\"width: {1}; height: {2}\" wrap=\"virtual\">{3}</textarea>",
						this.UniqueID,
						this.Width,
						this.Height,
						System.Web.HttpUtility.HtmlEncode( this.Value ) ) ;
			}

			writer.Write( "</div>" ) ;
		}

		public void RaisePostDataChangedEvent()
		{
			// Do nothing
		}

		private object IsNull( object valueToCheck, object replacementValue )
		{
			return valueToCheck == null ? replacementValue : valueToCheck ;
		}
	}
}
