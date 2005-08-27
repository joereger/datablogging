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
 * File Name: FCKeditorConfigurations.cs
 * 	Class that holds all editor configurations.
 * 
 * Version:  2.0 Beta 2
 * Modified: 2004-05-31 23:17:23
 * 
 * File Authors:
 * 		Frederico Caldeira Knabben (fredck@fckeditor.net)
 */

using System ;
using System.Collections ;

namespace FredCK.FCKeditorV2
{
	public class FCKeditorConfigurations
	{
		private Hashtable colConfigs ;

		internal FCKeditorConfigurations()
		{
			colConfigs = new Hashtable() ;
		}

		public string this[ string configurationName ]
		{
			get
			{
				if ( colConfigs.ContainsKey( configurationName ) )
					return (string)colConfigs[ configurationName ] ;
				else
					return null ;
			}
			set
			{
				colConfigs[ configurationName ] = value ;
			}
		}

		internal string GetHiddenFieldString()
		{
			System.Text.StringBuilder osParams = new System.Text.StringBuilder() ;

			foreach ( DictionaryEntry oEntry in colConfigs )
			{
				if ( osParams.Length > 0 )
					osParams.Append( '&' ) ;

				osParams.AppendFormat( "{0}={1}", System.Web.HttpUtility.HtmlEncode( oEntry.Key.ToString() ), System.Web.HttpUtility.HtmlEncode( oEntry.Value.ToString() ) ) ;
			}

			return osParams.ToString() ;
		}
	}
}
