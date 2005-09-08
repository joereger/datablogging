/* 
SQLyog v3.64
Host - localhost : Database - baseqlogger
**************************************************************
Server version 4.1.1a-alpha-nt
*/

/*
Table structure for account
*/

CREATE TABLE `account` (
  `accountid` int(11) NOT NULL auto_increment,
  `accounttypeid` int(11) NOT NULL default '0',
  `servername` varchar(255) NOT NULL default '',
  `customservername` varchar(255) default NULL,
  `plid` int(11) NOT NULL default '0',
  `templateid` int(11) NOT NULL default '0',
  `homepagehtml` longtext,
  `homepagetitle` varchar(100) default NULL,
  `createdate` datetime NOT NULL default '0000-00-00 00:00:00',
  `timezoneid` varchar(150) NOT NULL default 'EST',
  `jspopup` int(11) NOT NULL default '1',
  `homepagecalendar` int(11) NOT NULL default '1',
  `messagesstatus` int(11) NOT NULL default '1',
  `messagesapproval` int(11) NOT NULL default '1',
  `gps` int(11) NOT NULL default '0',
  `admintools` int(11) NOT NULL default '0',
  `pingweblogscom` int(11) NOT NULL default '1',
  `showhometab` int(11) NOT NULL default '1',
  `hometabtext` varchar(50) default NULL,
  `showlogintab` int(11) NOT NULL default '1',
  `displaycharsinsummary` int(11) NOT NULL default '500',
  `displaynumberofentries` int(11) NOT NULL default '15',
  `userelatedlinks` int(11) NOT NULL default '1',
  `favesitetitle` varchar(50) default NULL,
  `favesiteon` int(11) NOT NULL default '0',
  `onthisday` int(11) NOT NULL default '1',
  `emailnewsletter` int(11) NOT NULL default '1',
  `emailsendhour` int(11) NOT NULL default '3',
  `monthlycharge` decimal(11,0) NOT NULL default '0',
  `issearchmysiteon` int(11) NOT NULL default '1',
  `maxspaceinbytes` int(11) NOT NULL default '0',
  `maxmonthlyhits` int(11) NOT NULL default '0',
  `istrackbackon` int(11) NOT NULL default '1',
  `islistedindirectory` int(11) NOT NULL default '1',
  `trackbackrequiresapproval` int(11) NOT NULL default '1',
  PRIMARY KEY  (`accountid`),
  FULLTEXT KEY `servername` (`servername`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


CREATE TABLE `accounttype` (
  `accounttypeid` int(11) NOT NULL default '0',
  `accounttypename` varchar(50) NOT NULL default '',
  PRIMARY KEY  (`accounttypeid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

INSERT INTO `accounttype` VALUES 
(0,'Free'),
(1,'Trial'),
(2,'Pro'),
(3,'Comp');

CREATE TABLE `accountuser` (
  `accountuserid` int(11) NOT NULL auto_increment,
  `isactive` int(11) NOT NULL default '0',
  `accountid` int(11) NOT NULL default '0',
  `accountusertypeid` int(11) NOT NULL default '0',
  `password` varchar(50) NOT NULL default '',
  `username` varchar(50) NOT NULL default '',
  `friendlyname` varchar(100) default NULL,
  `onelinesummary` varchar(255) default NULL,
  `passphrasequestion` varchar(255) NOT NULL default '',
  `passphraseanswer` varchar(50) NOT NULL default '',
  `email` varchar(100) default NULL,
  `lastlogindate` datetime default NULL,
  `entrymode` int(11) NOT NULL default '0',
  `usertimezoneid` varchar(255) NOT NULL default 'EST',
  `createdate` datetime NOT NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (`accountuserid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `accountuseracl` (
  `accountuseraclid` int(11) NOT NULL auto_increment,
  `accountuserid` int(11) NOT NULL default '0',
  `aclobjectid` int(11) NOT NULL default '0',
  PRIMARY KEY  (`accountuseraclid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `accountuserfield` (
  `accountuserfieldid` int(11) NOT NULL auto_increment,
  `accountuserid` int(11) NOT NULL default '0',
  `fieldtitle` varchar(255) default NULL,
  `fielddata` mediumtext,
  `order` int(11) NOT NULL default '1',
  PRIMARY KEY  (`accountuserfieldid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

CREATE TABLE `accountuserlogaccess` (
  `accountuserlogaccessid` int(11) NOT NULL auto_increment,
  `accountuserid` int(11) NOT NULL default '0',
  `logid` int(11) NOT NULL default '0',
  PRIMARY KEY  (`accountuserlogaccessid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*
Table structure for accountusertype
*/

CREATE TABLE `accountusertype` (
  `accountusertypeid` int(11) NOT NULL default '0',
  `type` varchar(50) NOT NULL default '',
  `description` varchar(255) NOT NULL default '',
  PRIMARY KEY  (`accountusertypeid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*
Table data for baseqlogger.accountusertype
*/

INSERT INTO `accountusertype` VALUES 
(1,'Owner','This is the primary account user.  They have full control.'),
(2,'User','A user who may have many or few account permissions.'),
(3,'Visitor','A person who registers on the public site.'),
(4,'Masteradmin','A master admin user.  Only for internal use.');


/*
Table structure for aclobject
*/

CREATE TABLE `aclobject` (
  `aclobjectid` int(11) NOT NULL default '0',
  `aclobjectname` varchar(50) NOT NULL default '',
  `aclfriendlyname` varchar(50) NOT NULL default '',
  `acldesc` longtext NOT NULL,
  PRIMARY KEY  (`aclobjectid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table data for baseqlogger.aclobject
*/

INSERT INTO `aclobject` VALUES 
(1,'ADMINHOME','Admin home page.',''),
(3,'CUSTOMIZELOG','Customize Log','The ability to customize a log\'s properties and setup.'),
(4,'CUSTOMIZE','Customize Site Properties','Customize site properties.'),
(5,'SAVECHARTS','Save Charts','The ability to save charts and graphs with a name so that they appear on the site as pre-built.'),
(6,'MASTERADMIN','Masteradmin section.',''),
(7,'DELETECHARTS','Delete a chart from a log',''),
(8,'ADDMEDIA','Add Images/Media',''),
(9,'CHANGESKIN','Change Site Skins',''),
(10,'MANAGEACCOUNTS','Manage other people\'s accounts','Manage account permissions that control what other users can do.  Note: giving this permission to somebody does not mean that they can assign any permission to anybody.  It only means that they can assign permissions that they already have.  For example, if they can\'t delete a visitor account then they can\'t assign the permission to delete a visitor account to another user.'),
(13,'EDITENTRIES','Edit an existing log entry.',''),
(12,'MOBILE','Use the mobile phone WAP interface.',''),
(11,'NEWLOG','Add a new log to the account.',''),
(14,'PUBLISHWITHOUTAPPROVAL','Publish a log entry without approval.',''),
(15,'ADDEDITENTRIES','Add and edit entries.',''),
(16,'APPROVEENTRIES','Approve entries.',''),
(17,'CHANGEAUTHORSHIP','Change Authorship of an Entry.',''),
(2,'DELETELOG','Delete a log.','');


/*
Table structure for bug
*/

CREATE TABLE `bug` (
  `bugid` int(11) NOT NULL auto_increment,
  `createdate` datetime default NULL,
  `isopen` int(11) default NULL,
  `severity` int(11) default NULL,
  `bugcategoryid` int(11) default NULL,
  `title` varchar(255) default NULL,
  PRIMARY KEY  (`bugid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for bugcategory
*/

CREATE TABLE `bugcategory` (
  `bugcategoryid` int(11) NOT NULL auto_increment,
  `bugcategory` varchar(50) default NULL,
  PRIMARY KEY  (`bugcategoryid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for bugcomment
*/

CREATE TABLE `bugcomment` (
  `bugcommentid` int(11) NOT NULL auto_increment,
  `bugid` int(11) default NULL,
  `date` datetime default NULL,
  `comment` mediumtext,
  PRIMARY KEY  (`bugcommentid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for conversioneventidoldtonew
*/

CREATE TABLE `conversioneventidoldtonew` (
  `conversionEventidOldToNewid` int(10) unsigned NOT NULL auto_increment,
  `oldeventid` int(11) default NULL,
  `neweventid` int(11) default NULL,
  `oldaccountid` int(11) default NULL,
  `newaccountid` int(11) default NULL,
  PRIMARY KEY  (`conversionEventidOldToNewid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for conversionimageidoldtonew
*/

CREATE TABLE `conversionimageidoldtonew` (
  `conversionImageOldToNewid` int(10) unsigned NOT NULL auto_increment,
  `oldimageid` int(11) default NULL,
  `newimageid` int(11) default NULL,
  `oldaccountid` int(11) default NULL,
  `newaccountid` int(11) default NULL,
  PRIMARY KEY  (`conversionImageOldToNewid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for conversionlogidoldtonew
*/

CREATE TABLE `conversionlogidoldtonew` (
  `conversionLogOldToNewid` int(10) unsigned NOT NULL auto_increment,
  `oldlogid` int(11) default NULL,
  `newlogid` int(11) default NULL,
  `oldaccountid` int(11) default NULL,
  `newaccountid` int(11) default NULL,
  PRIMARY KEY  (`conversionLogOldToNewid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for databaseversion
*/

CREATE TABLE `databaseversion` (
  `databaseversionid` int(11) NOT NULL auto_increment,
  `version` int(11) NOT NULL default '0',
  `date` datetime default NULL,
  PRIMARY KEY  (`databaseversionid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table data for baseqlogger.databaseversion
*/

INSERT INTO `databaseversion` VALUES 
(1,0,'0000-00-00 00:00:00');

/*
Table structure for emailapi
*/

CREATE TABLE `emailapi` (
  `emailapiid` int(11) NOT NULL auto_increment,
  `accountuserid` int(11) NOT NULL default '0',
  `emailsecret` varchar(10) default NULL,
  `overridecamphonesubject` int(11) default NULL,
  `overridecamphonesubjecttext` varchar(255) default NULL,
  `ignorecamphonebody` int(11) default NULL,
  `consolidatecamphonetoonedailyentry` int(11) default NULL,
  `saveemailpostsasdraft` int(11) default NULL,
  `savecamphonepostsasdraft` int(11) default NULL,
  `camphoneimagecategoryid` int(11) default NULL,
  PRIMARY KEY  (`emailapiid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*
Table structure for emailsubscriber
*/

CREATE TABLE `emailsubscriber` (
  `emailsubscriberid` int(11) NOT NULL auto_increment,
  `sendeveryxdays` int(11) NOT NULL default '7',
  `emailaddress` varchar(50) NOT NULL default '',
  `accountid` int(11) NOT NULL default '0',
  `htmlemail` int(11) NOT NULL default '1',
  `lastsentdate` datetime default NULL,
  PRIMARY KEY  (`emailsubscriberid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for error
*/

CREATE TABLE `error` (
  `errorid` int(11) NOT NULL auto_increment,
  `date` datetime default NULL,
  `url` longtext,
  `description` longtext,
  `status` varchar(50) default NULL,
  `accountid` int(11) default NULL,
  `count` int(11) NOT NULL default '1',
  PRIMARY KEY  (`errorid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for event
*/

CREATE TABLE `event` (
  `eventid` int(11) NOT NULL auto_increment,
  `eventtypeid` int(11) NOT NULL default '0',
  `locationid` int(11) NOT NULL default '0',
  `createdate` datetime NOT NULL default '0000-00-00 00:00:00',
  `date` datetime NOT NULL default '0000-00-00 00:00:00',
  `title` varchar(255) NOT NULL default 'Log Entry',
  `comments` longtext,
  `accountid` int(11) NOT NULL default '0',
  `logid` int(11) NOT NULL default '0',
  `accountuserid` int(11) NOT NULL default '0',
  `isdraft` int(11) NOT NULL default '1',
  `isapproved` int(11) NOT NULL default '1',
  `favorite` int(11) NOT NULL default '0',
  `sizeinbytes` int(11) NOT NULL default '0',
  PRIMARY KEY  (`eventid`),
  KEY `eventid` (`eventid`,`date`,`accountid`,`logid`),
  FULLTEXT KEY `title` (`title`,`comments`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for favesite
*/

CREATE TABLE `favesite` (
  `favesiteid` int(11) NOT NULL auto_increment,
  `name` varchar(255) NOT NULL default '',
  `url` longtext NOT NULL,
  `accountid` int(11) NOT NULL default '0',
  PRIMARY KEY  (`favesiteid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for friend
*/

CREATE TABLE `friend` (
  `friendid` int(11) NOT NULL auto_increment,
  `accountuseridsource` int(11) NOT NULL default '0',
  `accountuseridtarget` int(11) NOT NULL default '0',
  PRIMARY KEY  (`friendid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for friendinvitation
*/

CREATE TABLE `friendinvitation` (
  `friendinvitationid` int(11) NOT NULL auto_increment,
  `accountuseridsource` int(11) NOT NULL default '0',
  `accountuseridtarget` int(11) default NULL,
  `status` int(11) NOT NULL default '0',
  `email` varchar(255) NOT NULL default '',
  `subject` varchar(255) NOT NULL default '',
  `message` mediumtext,
  `createdate` datetime NOT NULL default '0000-00-00 00:00:00',
  `emaillastsentdate` datetime default NULL,
  PRIMARY KEY  (`friendinvitationid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for friendmessage
*/

CREATE TABLE `friendmessage` (
  `friendmessageid` int(11) NOT NULL auto_increment,
  `accountuserid` int(11) NOT NULL default '0',
  `subject` varchar(255) default NULL,
  `message` longtext,
  `datetime` datetime default NULL,
  `parentfriendmessageid` int(11) default NULL,
  PRIMARY KEY  (`friendmessageid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for friendmessagerecipient
*/

CREATE TABLE `friendmessagerecipient` (
  `friendmessagerecipientid` int(11) NOT NULL auto_increment,
  `friendmessageid` int(11) NOT NULL default '0',
  `accountuserid` int(11) NOT NULL default '0',
  `isread` int(11) NOT NULL default '0',
  PRIMARY KEY  (`friendmessagerecipientid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for help
*/

CREATE TABLE `help` (
  `helpid` int(11) NOT NULL auto_increment,
  `helpkey` varchar(50) default NULL,
  `helpsection` int(11) default NULL,
  `eventtypeid` int(11) default '-1',
  `title` varchar(255) default NULL,
  `body` longtext,
  PRIMARY KEY  (`helpid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for homepageconfig
*/

CREATE TABLE `homepageconfig` (
  `homepageconfigid` int(11) NOT NULL auto_increment,
  `accountid` int(11) NOT NULL default '0',
  `homepageconfigobjectid` int(11) NOT NULL default '0',
  `colnum` int(11) default NULL,
  `rownum` int(11) default NULL,
  PRIMARY KEY  (`homepageconfigid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for homepageconfigobject
*/

CREATE TABLE `homepageconfigobject` (
  `homepageconfigobjectid` int(11) NOT NULL auto_increment,
  `classname` varchar(255) NOT NULL default '',
  `friendlyname` varchar(75) NOT NULL default '',
  `description` mediumtext,
  PRIMARY KEY  (`homepageconfigobjectid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table data for baseqlogger.homepageconfigobject
*/

INSERT INTO `homepageconfigobject` VALUES 
(1,'reger.HomePageListOfEntries','Web Log Entries','A list of web log entries.  This is the traditional web log homepage.  Organized in reverse chronological order.'),
(2,'reger.HomePage15MostReadLast7Days','15 Most Read Last 7 Days','This is a list of the titles of the most read web log entries over the last seven days.'),
(3,'reger.HomePage15RandomImagesVertical','15 Random Images Arranged Vertically','It\'s fun to put a list of random images on your home page.  These are arranged vertically.'),
(4,'reger.HomePage15MostRecentImagesVertical','15 Most Recent Images Vertical','The 15 most recently added images listed in reverse chronological order.'),
(5,'reger.HomePage15MostRecent','15 Most Recent Entry Headlines','Headlines (titles) for the 15 most recent web log entries.'),
(6,'reger.HomePage15FavoriteEntries','15 Favorite Entries','Your 15 most recent favorite entries.'),
(7,'reger.HomePageOnThisDay','On This Day','A list of web log entries made on this date in history.');


/*
Table structure for image
*/

CREATE TABLE `image` (
  `imageid` int(11) NOT NULL auto_increment,
  `eventid` int(11) NOT NULL default '0',
  `accountuserid` int(11) NOT NULL default '0',
  `image` varchar(255) NOT NULL default '',
  `description` longtext,
  `sizeinbytes` int(11) NOT NULL default '0',
  `imagecategoryid` int(11) default NULL,
  `order` int(11) default NULL,
  PRIMARY KEY  (`imageid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for imagecategory
*/

CREATE TABLE `imagecategory` (
  `imagecategoryid` int(11) NOT NULL auto_increment,
  `accountid` int(11) NOT NULL default '0',
  `imagecategory` varchar(50) NOT NULL default '',
  PRIMARY KEY  (`imagecategoryid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for linkrot
*/

CREATE TABLE `linkrot` (
  `linkrotid` int(11) NOT NULL auto_increment,
  `url` text,
  `keywords` text,
  `lastcheckeddate` datetime default NULL,
  `isbroken` int(11) default NULL,
  `httpstatuscode` int(11) default NULL,
  PRIMARY KEY  (`linkrotid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for linkroteventlookup
*/

CREATE TABLE `linkroteventlookup` (
  `linkroteventlookupid` int(11) NOT NULL auto_increment,
  `linkrotid` int(11) NOT NULL default '0',
  `eventid` int(11) NOT NULL default '0',
  PRIMARY KEY  (`linkroteventlookupid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for linkrotrecommendation
*/

CREATE TABLE `linkrotrecommendation` (
  `linkrotrecommendationid` int(11) NOT NULL auto_increment,
  `linkrotid` int(11) default NULL,
  `url` text,
  `source` varchar(100) default NULL,
  PRIMARY KEY  (`linkrotrecommendationid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for location
*/

CREATE TABLE `location` (
  `locationid` int(11) NOT NULL auto_increment,
  `locationname` varchar(255) NOT NULL default '',
  `accountid` int(11) NOT NULL default '0',
  `latdeg` int(11) default NULL,
  `latmin` int(11) default NULL,
  `latsec` int(11) default NULL,
  `latns` int(11) default NULL,
  `londeg` int(11) default NULL,
  `lonmin` int(11) default NULL,
  `lonsec` int(11) default NULL,
  `lonew` int(11) default NULL,
  PRIMARY KEY  (`locationid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*
Table structure for loginhistory
*/

CREATE TABLE `loginhistory` (
  `loginhistoryid` int(11) NOT NULL auto_increment,
  `accountuserid` int(11) NOT NULL default '0',
  `date` datetime NOT NULL default '0000-00-00 00:00:00',
  `usertype` varchar(50) default NULL,
  `enteredpassword` varchar(50) NOT NULL default '',
  `success` int(11) default NULL,
  PRIMARY KEY  (`loginhistoryid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for megachart
*/

CREATE TABLE `megachart` (
  `megachartid` int(11) NOT NULL auto_increment,
  `chartname` varchar(100) NOT NULL default '',
  `eventtypeid` int(11) NOT NULL default '0',
  `logid` int(11) NOT NULL default '0',
  `xmegafieldid` int(11) NOT NULL default '0',
  `yaxiswhattodo` int(11) NOT NULL default '0',
  `chartsize` int(11) NOT NULL default '0',
  `charttype` int(11) NOT NULL default '0',
  `daterange` int(11) NOT NULL default '0',
  `lastxdays` int(11) NOT NULL default '0',
  `lastxweeks` int(11) NOT NULL default '0',
  `lastxmonths` int(11) NOT NULL default '0',
  `lastxyears` int(11) NOT NULL default '0',
  `daterangefromyyyy` int(11) NOT NULL default '0',
  `daterangefrommm` int(11) NOT NULL default '0',
  `daterangefromdd` int(11) NOT NULL default '0',
  `daterangetoyyyy` int(11) NOT NULL default '0',
  `daterangetomm` int(11) NOT NULL default '0',
  `daterangetodd` int(11) NOT NULL default '0',
  `custommath1` int(11) NOT NULL default '0',
  `custommathoperator1` int(11) NOT NULL default '0',
  `custommath2` int(11) NOT NULL default '0',
  `custommathnumber1` double NOT NULL default '0',
  PRIMARY KEY  (`megachartid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*
Table data for baseqlogger.megachart
*/

INSERT INTO `megachart` VALUES 
(1,'Distance vs. Time',1,0,-2,1,3,1,1,1,1,1,1,2003,2,9,2004,2,9,11,1,11,0),
(3,'Weekly Distance',1,0,-7,1,3,4,1,1,1,1,1,2003,2,9,2004,2,9,11,1,11,0),
(5,'Distance by Day of Week',1,0,-5,1,3,4,1,1,1,1,1,2003,2,9,2004,2,9,11,1,11,0),
(6,'Heart Rate vs. Time',1,0,-2,1,3,1,1,1,1,1,1,2003,2,9,2004,2,9,11,1,11,0),
(7,'Distance by Bike',1,0,6,1,3,6,1,1,1,1,1,2003,2,9,2004,2,9,11,1,11,0),
(8,'Distance by Ride Type',1,0,10,1,3,7,1,1,1,1,1,2003,2,9,2004,2,9,11,1,11,0),
(9,'Caffeine vs. Time',2,0,-2,2,3,1,1,1,1,1,1,2003,2,9,2004,2,9,99,1,99,0),
(10,'Caffeine This Month',2,0,-6,2,3,1,2,1,1,1,1,2003,2,9,2004,2,9,99,1,99,0),
(11,'Caffeine By Hour of the Day',2,0,-3,2,3,4,2,1,1,1,1,2003,2,9,2004,2,9,99,1,99,0),
(12,'Caffeine By Day of the Week',2,0,-5,2,3,4,2,1,1,1,1,2003,2,9,2004,2,9,99,1,99,0),
(13,'Monthly Caffeine This Year',2,0,-8,2,3,4,4,1,1,1,1,2003,2,9,2004,2,9,99,1,99,0),
(14,'Weekly Caffeine',2,0,-7,2,3,4,1,1,1,1,1,2003,2,9,2004,2,9,99,1,99,0),
(15,'Pants by Rating',3,0,13,1,3,4,1,1,1,1,1,2003,2,9,2004,2,9,15,1,15,0),
(16,'Shirt by Rating',3,0,12,1,3,4,1,1,1,1,1,2003,2,9,2004,2,9,15,1,15,0),
(17,'Shoes by Rating',3,0,14,1,3,4,1,1,1,1,1,2003,2,9,2004,2,9,15,1,15,0),
(18,'Bikes by Number of Times Ridden',1,0,6,2,3,7,1,1,1,1,1,2003,2,9,2004,2,9,11,1,11,0),
(20,'Ride Type by Number of Rides',1,0,10,2,3,7,1,1,1,1,1,2003,2,9,2004,2,9,11,1,11,0),
(26,'Item by Number of Consumptions',2,0,99,2,3,7,1,1,1,1,1,2003,2,9,2004,2,9,99,1,99,0),
(24,'Pants Number of Times Worn',3,0,13,2,3,6,1,1,1,1,1,2003,2,9,2004,2,9,15,1,15,0),
(23,'Shirt Number of Times Worn',3,0,12,2,3,6,1,1,1,1,1,2003,2,9,2004,2,9,15,1,15,0),
(25,'Shoes Number of Times Worn',3,0,14,2,3,6,1,1,1,1,1,2003,2,9,2004,2,9,15,1,15,0),
(28,'Times Each Commute Made',4,0,16,2,3,4,1,1,1,1,1,2003,2,9,2004,2,9,-1,1,-2,0),
(29,'Time Spent in Each Commute',4,0,16,2,3,4,1,1,1,1,1,2003,2,9,2004,2,9,17,1,-2,0),
(30,'Daily Commute This Month',4,0,-6,2,3,4,3,1,1,1,1,2003,2,9,2004,2,9,17,1,-2,0),
(31,'Weekly Commute This Month',4,0,-7,2,3,4,3,1,1,1,1,2003,2,9,2004,2,9,17,1,-2,0),
(32,'Commute by Hour of Day',4,0,-3,2,3,4,3,1,1,1,1,2003,2,9,2004,2,9,17,1,-2,0),
(33,'Speed (units/second)',8,0,-4,1,3,1,1,1,1,1,1,2003,2,9,2004,2,9,55,4,56,0),
(39,'Weekly Distance',8,0,-7,1,3,4,1,1,1,1,1,2003,2,9,2004,2,9,55,4,56,0),
(46,'Distance by Hour of Day',8,0,-3,2,3,1,1,1,1,1,1,2003,2,9,2004,2,9,55,4,56,0),
(47,'Distance by Day of the Week',8,0,-5,2,3,1,1,1,1,1,1,2003,2,9,2004,2,9,55,4,56,0),
(48,'Running Surface vs. Distance',8,0,58,2,3,1,1,1,1,1,1,2003,2,9,2004,2,9,55,4,56,0),
(45,'Monthly Distance',8,0,-8,2,3,4,1,1,1,1,1,2003,2,9,2004,2,9,55,4,56,0),
(41,'Hills By Run',8,0,-4,1,3,1,1,1,1,1,1,2003,2,9,2004,2,9,55,4,56,0),
(44,'Shoes Number of Times Worn',8,0,60,2,3,1,1,1,1,1,1,2003,2,9,2004,2,9,55,4,56,0),
(43,'Shoes Distance',8,0,60,2,3,1,1,1,1,1,1,2003,2,9,2004,2,9,55,4,56,0),
(49,'Heart Rate vs. Date',8,0,-2,1,3,1,1,1,1,1,1,2003,2,9,2004,2,9,55,4,56,0),
(50,'Temperature vs. Exertion',8,0,59,1,3,1,1,1,1,1,1,2003,2,9,2004,2,9,55,4,56,0),
(51,'Temperature vs. Distance',8,0,59,2,3,1,1,1,1,1,1,2003,2,9,2004,2,9,55,4,56,0),
(53,'Partner Ratings',9,0,63,1,3,4,1,1,1,1,1,2003,2,9,2004,2,9,66,1,66,0),
(54,'Number of Orgasms by Partner',9,0,63,2,3,4,1,1,1,1,1,2003,2,9,2004,2,9,66,1,66,0),
(55,'Time Sex Lasted For vs. Partner',9,0,63,2,3,4,1,1,1,1,1,2003,2,9,2004,2,9,66,1,66,0),
(56,'Number of Orgasms by Week',9,0,-7,2,3,4,1,1,1,1,1,2003,2,9,2004,2,9,66,1,66,0),
(57,'Number of Entries by Week',9,0,-7,2,3,4,1,1,1,1,1,2003,2,9,2004,2,9,66,1,66,0),
(58,'Number of Entries by Month',9,0,-8,2,3,4,1,1,1,1,1,2003,2,9,2004,2,9,66,1,66,0),
(59,'Number of Orgasms by Month',9,0,-8,2,3,4,1,1,1,1,1,2003,2,9,2004,2,9,66,1,66,0),
(60,'Number of Orgasms by Date',9,0,-2,2,3,4,1,1,1,1,1,2003,2,9,2004,2,9,66,1,66,0),
(61,'Initiated By Percentage',9,0,69,2,3,7,1,1,1,1,1,2003,2,9,2004,2,9,66,1,66,0),
(62,'Initiated By Number',9,0,69,2,3,4,1,1,1,1,1,2003,2,9,2004,2,9,66,1,66,0),
(63,'Partner Orgasm',9,0,71,2,3,4,1,1,1,1,1,2003,2,9,2004,2,9,66,1,66,0),
(64,'Orgasm Rating vs. Passion Rating',9,0,65,1,3,4,1,1,1,1,1,2003,2,9,2004,2,9,66,1,66,0),
(65,'Number of Entries by Day of the Month',9,0,-6,2,3,4,1,1,1,1,1,2003,2,9,2004,2,9,66,1,66,0),
(66,'Number of Orgasms by Day of the Month',9,0,-6,2,3,4,1,1,1,1,1,2003,2,9,2004,2,9,66,1,66,0),
(67,'Number of Orgasms by Hour of the Day',9,0,-3,2,3,4,1,1,1,1,1,2003,2,9,2004,2,9,66,1,66,0),
(68,'Number of Entries by Hour of the Day',9,0,-3,2,3,4,1,1,1,1,1,2003,2,9,2004,2,9,66,1,66,0),
(69,'Daily Smoking Over Time',6,0,-9,2,3,1,1,1,1,1,1,2003,2,9,2004,2,9,45,1,45,0),
(71,'Stash Summary',6,0,40,2,3,1,1,1,1,1,1,2003,2,9,2004,2,9,45,1,45,0),
(72,'Number of Hits vs. High Lasted For',6,0,41,2,3,1,1,1,1,1,1,2003,2,9,2004,2,9,45,1,45,0),
(73,'Times Each Stash Used',6,0,40,2,3,7,1,1,1,1,1,2003,2,9,2004,2,9,45,1,45,0),
(74,'What Rated Movies?',15,0,97,2,3,1,1,1,1,1,1,2003,2,10,2004,2,10,93,1,93,0),
(75,'How Movies are Watched',15,0,96,2,3,1,1,1,1,1,1,2003,2,10,2004,2,10,93,1,93,0),
(76,'Hour of the Day Movies Are Watched',15,0,-3,2,3,4,1,1,1,1,1,2003,2,10,2004,2,10,93,1,93,0),
(77,'Type of Movies Watched',15,0,95,2,3,7,1,1,1,1,1,2003,2,10,2004,2,10,93,1,93,0),
(78,'Jumps  by Day of the Week',10,0,-5,2,3,4,1,1,1,1,1,2003,2,10,2004,2,10,76,1,76,0),
(79,'Aircraft Jumped From',10,0,73,2,3,7,1,1,1,1,1,2003,2,10,2004,2,10,76,1,76,0),
(80,'Main Canopy Summary',10,0,79,2,3,4,1,1,1,1,1,2003,2,10,2004,2,10,76,1,76,0),
(81,'Exit and Deployment Altitudes',10,0,-2,2,3,4,1,1,1,1,1,2003,2,10,2004,2,10,76,1,76,0),
(82,'Jumps by Days Ago',10,0,-9,2,3,4,1,1,1,1,1,2003,2,10,2004,2,10,76,1,76,0),
(84,'Daily Distance',11,0,-9,2,3,4,1,1,1,1,1,2003,2,10,2004,2,10,86,1,86,0),
(85,'Weekly Distance',11,0,-7,2,3,4,1,1,1,1,1,2003,2,10,2004,2,10,86,1,86,0),
(86,'Monthly Distance',11,0,-8,2,3,4,1,1,1,1,1,2003,2,10,2004,2,10,86,1,86,0),
(87,'Daily Time',11,0,-9,2,3,4,1,1,1,1,1,2003,2,10,2004,2,10,86,1,86,0),
(88,'Weekly Time',11,0,-7,2,3,4,1,1,1,1,1,2003,2,10,2004,2,10,86,1,86,0),
(89,'Monthly Time',11,0,-8,2,3,4,1,1,1,1,1,2003,2,10,2004,2,10,86,1,86,0),
(90,'Distance by Hour of Day',11,0,-3,2,3,4,1,1,1,1,1,2003,2,10,2004,2,10,86,1,86,0),
(91,'Distance by Day of the Week',11,0,-5,2,3,4,1,1,1,1,1,2003,2,10,2004,2,10,86,1,86,0),
(92,'Pool Size',11,0,88,2,3,7,1,1,1,1,1,2003,2,10,2004,2,10,86,1,86,0),
(93,'Heart Rates',11,0,-2,2,3,1,1,1,1,1,1,2003,2,10,2004,2,10,86,1,86,0),
(94,'Avg Heart Rate vs. Distance',11,0,86,2,3,1,1,1,1,1,1,2003,2,10,2004,2,10,86,1,86,0),
(95,'Type of Swim',11,0,89,2,3,7,1,1,1,1,1,2003,2,10,2004,2,10,86,1,86,0);


/*
Table structure for megachartyaxis
*/

CREATE TABLE `megachartyaxis` (
  `megachartyaxisid` int(11) NOT NULL auto_increment,
  `megachartid` int(11) NOT NULL default '0',
  `ymegafieldid` int(11) NOT NULL default '0',
  PRIMARY KEY  (`megachartyaxisid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table data for baseqlogger.megachartyaxis
*/

INSERT INTO `megachartyaxis` VALUES 
(1,1,1),
(2,2,1),
(3,3,1),
(4,4,1),
(5,5,1),
(6,6,7),
(7,6,8),
(8,7,1),
(9,8,1),
(10,9,99),
(11,10,99),
(12,11,99),
(13,12,99),
(14,13,99),
(15,14,99),
(16,15,15),
(17,16,15),
(18,17,15),
(19,18,-2),
(20,19,-2),
(21,20,-2),
(22,21,-2),
(23,22,-2),
(24,23,-2),
(25,24,-2),
(26,25,-2),
(27,26,-2),
(28,27,-2),
(29,28,-2),
(30,29,17),
(31,30,17),
(32,31,17),
(33,32,17),
(34,33,-3),
(35,34,55),
(36,35,55),
(37,36,55),
(38,37,57),
(39,38,55),
(40,39,55),
(41,40,98),
(42,41,98),
(43,42,-2),
(44,43,55),
(45,44,-2),
(46,45,55),
(47,46,55),
(48,47,55),
(49,48,55),
(50,49,61),
(51,49,62),
(52,50,57),
(53,51,55),
(54,52,66),
(55,52,65),
(56,52,67),
(57,53,66),
(58,53,65),
(59,53,67),
(60,54,68),
(61,55,70),
(62,56,68),
(63,57,-2),
(64,58,-2),
(65,59,68),
(66,60,68),
(67,61,-2),
(68,62,-2),
(69,63,-2),
(70,64,67),
(71,65,-2),
(72,66,68),
(73,67,68),
(74,68,-2),
(75,69,-2),
(76,70,41),
(77,70,43),
(78,70,47),
(79,70,49),
(80,70,-2),
(81,71,41),
(82,71,43),
(83,71,47),
(84,71,49),
(85,71,-2),
(86,72,45),
(87,73,-2),
(88,74,-2),
(89,75,-2),
(90,76,-2),
(91,77,-2),
(92,78,-2),
(93,79,-2),
(94,80,-2),
(95,81,76),
(96,81,75),
(97,82,-2),
(98,83,83),
(99,84,83),
(100,85,83),
(101,86,83),
(102,87,85),
(103,88,85),
(104,89,85),
(105,90,83),
(106,91,83),
(107,92,-2),
(108,93,86),
(109,93,87),
(110,94,83),
(111,95,-2);


/*
Table structure for megadatatype
*/

CREATE TABLE `megadatatype` (
  `megadatatypeid` int(11) NOT NULL default '0',
  `megadatatypename` varchar(50) default NULL,
  `megadatatypedescription` longtext,
  PRIMARY KEY  (`megadatatypeid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table data for baseqlogger.megadatatype
*/

INSERT INTO `megadatatype` VALUES 
(1,'Number','Any number.  Decimals allowed.'),
(2,'Integer','Any number.  Decimals not allowed.  Only integers.'),
(3,'Alphanumeric','Any combination of letters, numbers and punctuation.'),
(5,'Date','A date.');


/*
Table structure for megadefault
*/

CREATE TABLE `megadefault` (
  `megadefaultid` int(11) NOT NULL auto_increment,
  `logid` int(11) default NULL,
  `megafieldid` int(11) default NULL,
  `megadefault` varchar(255) default NULL,
  `megadefaultextended` varchar(255) default NULL,
  PRIMARY KEY  (`megadefaultid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for megafield
*/

CREATE TABLE `megafield` (
  `megafieldid` int(11) NOT NULL auto_increment,
  `fieldtype` int(11) default NULL,
  `eventtypeid` int(11) default NULL,
  `fieldorder` int(11) default NULL,
  `fieldname` varchar(50) default NULL,
  `fielddescription` varchar(255) default NULL,
  `megadatatypeid` int(11) default NULL,
  `isrequired` int(11) default NULL,
  `numericmax` int(11) default NULL,
  `numericmin` int(11) default NULL,
  `step` int(11) default NULL,
  `maxtitle` varchar(50) default NULL,
  `mintitle` varchar(50) default NULL,
  `isvertical` int(11) default NULL,
  PRIMARY KEY  (`megafieldid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table data for qlogger.megafield
*/

INSERT INTO `megafield` VALUES 
(1,5,1,1,'Distance','',1,0,10,1,1,'','',NULL),
(2,8,1,1,'Time','',2,0,NULL,NULL,NULL,NULL,NULL,NULL),
(3,7,1,1,'Exertion','',1,0,10,1,1,'Hard','Easy',NULL),
(4,1,1,1,'Route','',3,0,10,1,1,'','',NULL),
(5,5,1,1,'Temperature','',1,0,10,1,1,'','',NULL),
(6,1,1,1,'Bike','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(7,5,1,1,'Average Heart Rate','',1,0,10,1,1,'','',NULL),
(8,5,1,1,'Maximum Heart Rate','',1,0,10,1,1,'','',NULL),
(9,1,1,1,'Wind','',3,0,10,1,1,'','',NULL),
(10,1,1,1,'Ride Type','Was this a race, training ride, interval session, etc?',3,0,10,1,1,'','',NULL),
(11,5,1,1,'Altitude','',1,0,10,1,1,'','',NULL),
(12,1,3,1,'Shirt','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(13,1,3,1,'Pants','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(14,1,3,1,'Shoes','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(15,7,3,1,'Rating','',1,0,10,1,1,'Good','Bad',NULL),
(16,3,4,1,'Which Commute','Example: \"To Work\"',3,1,10,1,1,'','',NULL),
(17,8,4,1,'Time','',2,0,NULL,NULL,NULL,NULL,NULL,NULL),
(18,1,5,1,'Course','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(19,8,5,1,'Time','',2,0,NULL,NULL,NULL,NULL,NULL,NULL),
(20,1,5,1,'Balls','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(21,1,5,1,'Clubset','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(22,5,5,1,'Hole 1 Score','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(23,5,5,1,'Hole 10 Score','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(24,5,5,1,'Hole 2 Score','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(25,5,5,1,'Hole 11 Score','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(26,5,5,1,'Hole 3 Score','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(27,5,5,1,'Hole 12 Score','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(28,5,5,1,'Hole 4 Score','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(29,5,5,1,'Hole 13 Score','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(30,5,5,1,'Hole 5 Score','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(31,5,5,1,'Hole 14 Score','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(32,5,5,1,'Hole 6 Score','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(33,5,5,1,'Hole 15 Score','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(34,5,5,1,'Hole 7 Score','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(35,5,5,1,'Hole 16 Score','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(36,5,5,1,'Hole 8 Score','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(37,5,5,1,'Hole 17 Score','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(38,5,5,1,'Hole 9 Score','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(39,5,5,1,'Hole 18 Score','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(40,1,6,1,'Stash','Ex. Stuff I Got From Sampson',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(41,5,6,1,'Number of Hits','',1,0,10,1,1,'','',NULL),
(42,1,6,1,'How','Ex: Joint, Bong, etc.',3,0,10,1,1,'','',NULL),
(43,7,6,1,'Rating','',1,0,10,1,1,'The Best Ever','Bad',NULL),
(44,1,6,1,'High Was','',3,0,10,1,1,'','',NULL),
(45,8,6,1,'High Lasted','',2,0,NULL,NULL,NULL,NULL,NULL,NULL),
(46,1,6,1,'Pot Type','',3,0,10,1,1,'','',NULL),
(47,7,6,1,'Seeds','',1,0,10,1,1,'Lots','None',NULL),
(48,5,6,1,'Color','',3,0,10,1,1,'','',NULL),
(49,7,6,1,'Stickiness Factor','',1,0,10,1,1,'Very Sticky','Very Dry',NULL),
(50,5,7,1,'Restaurant','',3,1,NULL,NULL,NULL,NULL,NULL,NULL),
(51,1,7,2,'Cuisine','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(52,7,7,1,'Food Rating','',1,0,10,1,1,'Good','Bad',NULL),
(53,7,7,1,'Service Rating','',1,0,10,1,1,'Good','Bad',NULL),
(54,7,7,1,'Atmosphere Rating','',1,0,10,1,1,'Good','Bad',NULL),
(55,5,8,1,'Distance','',1,0,10,1,1,'','',NULL),
(56,8,8,1,'Time','',2,0,NULL,NULL,NULL,NULL,NULL,NULL),
(57,7,8,1,'Exertion','',1,0,10,1,1,'High','Low',NULL),
(58,1,8,1,'Running Surface','',3,0,10,1,1,'','',NULL),
(59,5,8,1,'Temperature','',1,0,10,1,1,'','',NULL),
(60,1,8,1,'Shoes','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(61,5,8,1,'Average Heart Rate','',1,0,10,1,1,'','',NULL),
(62,5,8,1,'Maximum Heart Rate','',1,0,10,1,1,'','',NULL),
(63,1,9,1,'Partner Name','',3,0,10,1,1,'','',NULL),
(64,3,9,1,'Partner Gender','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(65,7,9,1,'My Orgasm Rating','',1,0,10,1,1,'The Best Ever','Bad',NULL),
(66,7,9,1,'Intimacy Rating','',1,0,10,1,1,'','',NULL),
(67,7,9,1,'Passion Rating','',1,0,10,1,1,'','',NULL),
(68,5,9,1,'Number of Orgasms','',1,0,10,1,1,'','',NULL),
(69,3,9,1,'Initiated By','',3,0,10,1,1,'','',NULL),
(70,8,9,1,'Lasted For','',2,0,NULL,NULL,NULL,NULL,NULL,NULL),
(71,3,9,1,'Partner Orgasm','Did partner achieve orgasm?',3,0,10,1,1,'','',NULL),
(72,5,10,1,'Jump Number','',1,0,10,1,1,'','',NULL),
(73,1,10,1,'Aircraft','',3,0,10,1,1,'','',NULL),
(74,5,10,1,'Maneuver','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(75,5,10,1,'Exit Altitude','',1,0,10,1,1,'','',NULL),
(76,5,10,1,'Deployment Altitude','',1,0,10,1,1,'','',NULL),
(77,8,10,1,'Freefall Time','',2,0,NULL,NULL,NULL,NULL,NULL,NULL),
(78,1,10,1,'Container','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(79,1,10,1,'Main Canopy','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(80,1,10,1,'Reserve Canopy','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(81,3,10,1,'Malfunction?','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(82,5,10,1,'Malfunction Type','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(83,5,11,1,'Distance','',1,0,10,1,1,'','',NULL),
(84,3,11,1,'Distance Units','',3,0,10,1,1,'','',NULL),
(85,8,11,1,'Time','',2,0,NULL,NULL,NULL,NULL,NULL,NULL),
(86,5,11,1,'Average Heart Rate','',1,0,10,1,1,'','',NULL),
(87,5,11,1,'Maximum Heart Rate','',1,0,10,1,1,'','',NULL),
(88,3,11,1,'Pool Size','',3,0,10,1,1,'','',NULL),
(89,1,11,1,'Swim Type','',3,0,10,1,1,'','',NULL),
(90,5,12,1,'Url','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(91,1,12,1,'Category','Ex. Political Links, Personal Links, etc.',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(92,5,15,1,'Director','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(93,8,15,1,'Movie Length','',2,0,NULL,NULL,NULL,NULL,NULL,NULL),
(94,7,15,1,'Rating','',1,0,10,1,1,'','',NULL),
(95,1,15,1,'Type','',3,0,10,1,1,'','',NULL),
(96,1,15,1,'How Seen','',3,0,10,1,1,'','',NULL),
(97,3,15,1,'Rated','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(98,7,8,1,'Hills','',1,0,10,1,1,'Many','None',NULL),
(99,1,2,1,'Mg Caffeine','Mg of caffeine consumed.',1,0,NULL,NULL,NULL,NULL,NULL,NULL),
(113,8,16,9,'Bike Time','',2,0,NULL,NULL,NULL,NULL,NULL,NULL),
(115,1,16,10,'Bike Ridden','The bike used on this ride.',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(118,1,16,11,'Bike Route','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(108,8,16,2,'Swim Time','',2,0,NULL,NULL,NULL,NULL,NULL,NULL),
(117,1,16,4,'Swim Stroke','',3,0,10,1,1,'','',NULL),
(116,5,16,13,'Bike Average Heart Rate','',1,0,10,1,1,'','',NULL),
(111,5,16,6,'Swim Average Heart Rate','',1,0,10,1,1,'','',NULL),
(100,5,16,15,'Run Distance','',1,0,10,1,1,'','',NULL),
(109,7,16,5,'Swim Exertion/Difficulty','',1,0,10,1,1,'Hard','Easy',NULL),
(102,7,16,19,'Run Exertion/Difficulty','',1,0,10,1,1,'Hard','Easy',NULL),
(104,1,16,18,'Run Shoes','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(114,7,16,12,'Bike Exertion/Difficulty','',1,0,10,1,1,'Hard','Easy',NULL),
(106,1,16,17,'Run Terrain','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(105,5,16,20,'Run Average Heart Rate','',1,0,10,1,1,'','',NULL),
(112,5,16,8,'Bike Distance','',1,0,10,1,1,'','',NULL),
(101,8,16,16,'Run Time','',2,0,10,1,1,'','',NULL),
(107,5,16,1,'Swim Distance','',1,0,10,1,1,'','',NULL),
(110,1,16,4,'Swim Where?','The pool, lake, ocean or other body of water for this swim.',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(121,5,16,21,'Run Max Heart Rate','',1,0,10,1,1,'','',NULL),
(119,5,16,14,'Bike Max Heart Rate','',1,0,10,1,1,'','',NULL),
(120,5,16,7,'Swim Max Heart Rate','',1,0,10,1,1,'','',NULL),
(122,8,17,1,'Headache Lasted For','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(123,5,17,3,'Suspected Cause','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(124,5,17,4,'Foods Eaten Prior to Headache','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(125,3,17,4,'Medicine Taken','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(126,7,17,5,'Medicine Effectiveness','Whether or not the medecine helped cure the headache.',1,0,10,1,1,'Very Effective','Not Effective',NULL),
(127,1,17,6,'Headache Started In','Area of  the head that the headache started in.',3,0,10,1,1,'','',NULL),
(128,5,18,1,'Tail Number','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(129,1,18,2,'Aircraft Type','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(130,1,18,4,'Aircraft Manufacturer','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(131,1,18,4,'Aircraft Model','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(132,5,18,5,'Aircraft Year','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(133,5,19,1,'Club/Bar Name','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(134,8,19,2,'Wait to Get In','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(135,7,19,4,'Ambience Rating','',1,0,10,1,1,'Great','Bad',NULL),
(136,7,19,4,'Dance Rating','Whether it was a good place to dance.',1,0,10,1,1,'Great','Bad',NULL),
(137,7,19,5,'Fashion Rating','How well people dressed.',1,0,10,1,1,'In Style','Out of Style',NULL),
(138,7,19,6,'Food Rating','',1,0,10,1,1,'Good','Bad',NULL),
(139,7,19,7,'Service Rating','',1,0,10,1,1,'Good','Bad',NULL),
(140,7,19,8,'Romance Rating','Whether this is a romantic place to take a date.',1,0,10,1,1,'Very Romantic','Not Very Romantic',NULL),
(141,7,20,1,'Freshness Rating','How fresh the trash was at this particular time.',1,0,10,1,1,'New','Old',NULL),
(142,5,20,2,'Type of Trash','Things found in the trash.',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(143,7,20,2,'Quality of Trash','',1,0,10,1,1,'Good','Bad',NULL),
(144,7,20,4,'Ease of Access','How easy it is to get to this trash.',1,0,10,1,1,'Very Easy','Very Hard',NULL),
(145,3,20,5,'Security','Whether security was present.',3,0,10,1,1,'','',NULL),
(146,7,20,6,'Park n Haul','Whether it was possible to park close to the dumpster for easy hauling.',1,0,10,1,1,'Park Very Close','Park Far Away',NULL),
(147,7,20,7,'Overall Rating','',1,0,10,1,1,'Great','Horrible',NULL),
(148,1,21,1,'Car','Which car was driven.',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(149,5,21,2,'Distance','Distance driven.',1,0,10,1,1,'','',NULL),
(150,5,21,4,'Trip Purpose','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(151,5,21,4,'Money Spent on Gas','',1,0,10,1,1,'','',NULL),
(152,8,21,5,'Driving Time','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(153,5,22,1,'Attendees','Who was present at the meeting.',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(154,7,22,2,'Productivity Rating','',1,0,10,1,1,'Very Productive','Not Very Productive',NULL),
(155,8,22,3,'Meeting Duration','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(156,5,23,1,'Ounces of Water Consumed','',1,0,10,1,1,'','',NULL),
(157,1,24,1,'Book','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(158,5,24,2,'Page Start','',1,0,10,1,1,'','',NULL),
(159,5,24,4,'Page End','',1,0,10,1,1,'','',NULL),
(160,1,24,2,'Author','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(161,7,24,5,'Reading Difficulty','',1,0,10,1,1,'Hard','Easy',NULL),
(162,7,24,6,'Enjoyment','How enjoyable this read was.',1,0,10,1,1,'Very','Not Very',NULL),
(163,8,25,1,'Sleep Time','Total time spent asleep.',2,0,NULL,NULL,NULL,NULL,NULL,NULL),
(164,7,25,2,'Quality of Sleep','',1,0,10,1,1,'Restful','Not Very Restful',NULL),
(165,3,25,3,'Dreams?','',3,0,10,1,1,'','',NULL),
(166,5,26,1,'Weight','',1,0,10,1,1,'','',NULL),
(168,5,27,1,'Name of Route','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(170,5,27,2,'Difficulty','i.e. 5.14a',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(171,3,27,3,'Type of Rock','',3,0,10,1,1,'','',NULL),
(172,7,27,4,'Exposure Rating','',1,0,10,1,1,'Very Exposed','No Exposure',NULL),
(173,7,27,5,'Route Enjoyment Factor','',1,0,10,1,1,'Fun/Enjoyable','Painful/No Fun',NULL),
(174,1,27,6,'Type of Climb','',3,0,10,1,1,'','',NULL),
(175,5,27,7,'Number of Falls','',1,0,10,1,1,'','',NULL),
(176,5,27,8,'Number of Attempts Before Success','',2,0,10,1,1,'','',NULL),
(177,8,27,9,'Time Spent on Route','',2,0,NULL,NULL,NULL,NULL,NULL,NULL),
(178,7,28,1,'Consistency','',1,0,10,1,1,'Hard','Loose',NULL),
(179,7,28,2,'Color','',1,0,5,1,1,'Dark','Light',NULL),
(180,7,28,3,'Ejection Difficulty','',1,0,10,1,1,'Hard','Easy',NULL),
(181,3,28,4,'Blood Present?','',3,0,10,1,1,'','',NULL),
(182,7,29,1,'Urine Color','',1,0,10,1,1,'Dark','Light/Clear',NULL),
(183,5,30,1,'Speech Topic','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(184,5,30,2,'Number of People in Audience','',2,0,10,1,1,'','',NULL),
(185,7,30,3,'Rating','',1,0,10,1,1,'The Perfect Speech','Room for Improvement',NULL),
(186,7,30,4,'Nervousness Factor','',1,0,10,1,1,'Calm, Cool and Collected','Shaky Breakdown Nervous',NULL),
(187,5,31,1,'My Team Name','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(188,5,31,2,'Opponent Team Name','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(189,5,31,3,'My Team Score','',2,0,10,1,1,'','',NULL),
(190,5,31,4,'Opponent Team Score','',2,0,10,1,1,'','',NULL),
(191,5,31,5,'Positions I Played','',3,0,NULL,NULL,NULL,NULL,NULL,NULL),
(192,1,31,6,'Field Conditions','',3,0,10,1,1,'','',NULL),
(193,8,32,1,'Time','Time spent doing this activity.',2,0,NULL,NULL,NULL,NULL,NULL,NULL),
(194,7,33,1,'Rating','',1,0,10,1,1,'','',NULL);



/*
Table structure for megafieldparam
*/

CREATE TABLE `megafieldparam` (
  `megafieldparamid` int(11) NOT NULL auto_increment,
  `oneworddatabasekey` varchar(255) NOT NULL default '',
  `megafieldid` int(11) NOT NULL default '0',
  `value` varchar(255) default NULL,
  PRIMARY KEY  (`megafieldparamid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for megafieldtype
*/

CREATE TABLE `megafieldtype` (
  `fieldtype` varchar(50) NOT NULL default '',
  `description` varchar(50) default NULL,
  PRIMARY KEY  (`fieldtype`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table data for baseqlogger.megafieldtype
*/

INSERT INTO `megafieldtype` VALUES 
('1','Dropdown'),
('2','Horizontal Radios'),
('3','Vertical Radios'),
('5','Text Box'),
('7','Numeric Range'),
('8','Time');


/*
Table structure for megalog
*/

CREATE TABLE `megalog` (
  `logid` int(11) NOT NULL auto_increment,
  `accountid` int(11) default NULL,
  `eventtypeid` int(11) default NULL,
  `name` varchar(50) default NULL,
  `logaccess` int(11) default NULL,
  `password` varchar(50) default NULL,
  `message` longtext,
  `showonhomepage` int(11) NOT NULL default '1',
  PRIMARY KEY  (`logid`),
  KEY `logid` (`logid`,`accountid`,`eventtypeid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for megalogtype
*/

CREATE TABLE `megalogtype` (
  `eventtypeid` int(11) NOT NULL auto_increment,
  `accountid` int(11) default NULL,
  `megalogname` varchar(50) default NULL,
  `description` longtext,
  `longdescription` longtext,
  `showlocation` int(11) default NULL,
  `isuserdefined` int(11) default NULL,
  `displaycolumns` int(11) default NULL,
  `icon` varchar(50) default NULL,
  `adminidentifier` varchar(50) default NULL,
  `showonhomepage` int(11) NOT NULL default '1',
  PRIMARY KEY  (`eventtypeid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table data for qlogger.megalogtype
*/

INSERT INTO `megalogtype` VALUES 
(1,-1,'Biking Log','Bike for health. Log for sanity.  The Biking Log allows you to keep track of the basics like distance and time but also allows you to keep track of mileage by bike, route usage and other important metrics to help your training regimen.',NULL,1,0,2,'log1.gif',NULL,1),
(2,-1,'Caffeine Log','Track daily caffeine consumption.  Each time you consume some Caffeine make a quick log entry.  Caffeine log entries won\'t appear on your homepage so they won\'t clutter it.  After logging for a while you\'ll be able to chart trends in your Caffeine consumption.',NULL,0,0,1,'log2.gif',NULL,0),
(3,-1,'Clothes Log','Worried that you may be wearing that blue shirt too often?  Log it!  Keep track of your daily shirt, shoes and pants.  Give them a rating each time you wear a combination and then see which combinations work best for you.',NULL,0,0,1,'log3.gif',NULL,1),
(4,-1,'Commute Log','What\'s the optimal time to leave for work?  How long do you spend on the road each day?  Which route to work is the most efficient?  Answer all of these questions by logging your commutes with the Commute Log.',NULL,0,0,1,'log4.gif',NULL,1),
(5,-1,'Golf Log','Keep track of the courses you\'ve played and the scores you shot.  Also track the clubs and balls that you use.',NULL,1,0,2,'log5.gif',NULL,1),
(6,-1,'Pot Log','Keep track of your pot smoking with this log.',NULL,1,0,2,'log6.gif',NULL,1),
(7,-1,'Restaurant Log','Keep a log of all of the restaurants that you\'ve been to.  Rate service, food, atmosphere.  Record what you eat.  You\'ll always have a list of restaurants and your own personal recommendation available.',NULL,0,0,1,'log7.gif',NULL,1),
(8,-1,'Running Log','Log distance, time, heart rate, hills, shoes and other running stats.  Get powerful charts that allow you to see your progress, peaking or other trends.',NULL,1,0,2,'log8.gif',NULL,1),
(9,-1,'Sex Log','Ah, sex.  You\'ve gotta love it.  So keep track of it.  Which partners are the most passionate?  Who usually initiates?  How many orgasms do you have?  Do you have more orgasms when you initiate?  Dig into your sex life with the Sex Log.',NULL,1,0,2,'log9.gif',NULL,1),
(10,-1,'Skydiving Log','Your online log book.  Everything you\'d expect from a skydiving log.  And you can share your photos with friends and family.',NULL,1,0,2,'log10.gif',NULL,1),
(11,-1,'Swimming Log','Log your swims to see your progress.  Distance, time, stroke and other swimming fields make it easy and fun.',NULL,1,0,1,'log11.gif',NULL,1),
(12,-1,'Url Log','Keep a list of your favorite sites, articles or online things.',NULL,1,0,1,'log12.gif',NULL,1),
(13,-1,'Basic Log','Get a Basic Log if you\'re not sure where to start.  A basic all-purpose log for logging anything you want.  No fancy data fields.  No flashy features.  Simply the bare essence of web logging.',NULL,1,0,1,'log13.gif',NULL,1),
(14,-1,'Picture Log','A Picture Log allows you to assign many pictures to a single web log entry.  For example, you can do a single entry for a birthday party and then assign any number of photos to it.  The Picture Log is a powerful way to share your photos online with friends and family.',NULL,1,0,1,'log14.gif',NULL,1),
(15,-1,'Movie Log','Two thumbs up?  Become your own movie critic with the Movie Log. ',NULL,1,0,1,'log15.gif',NULL,1),
(16,-1,'Triathlon Log','The Triathlon Log combines the best of the swimming, biking and running logs into one compact log.  You can record workouts from multiple disciplines in a single entry... great for those cross-training days or for races.  With the charting functions you can then compare numbers across disciplines.','',1,0,1,'',NULL,1),
(17,-1,'Headache Log','It\'s often difficult to identify the cause of headaches.  Use the Headache Log to record headaches.  Over time you may notice trends or causal relationships.  Hopefully you can use this information to prevent headaches.',NULL,1,0,1,NULL,NULL,1),
(18,-1,'Aircraft Spotting Log','Use this log to track all of the aircraft you spot.',NULL,1,0,1,NULL,NULL,1),
(19,-1,'Night Club/Bar Log','It takes a lot of time, energy and money to hit all the hip night spots.  Keep track of your progress with the Night Club/Bar Log.',NULL,1,0,1,NULL,NULL,1),
(20,-1,'Dumpster Diving Log','Record the best places to go dumpster diving.  Note trends in trash freshness.  Guage security concerns.',NULL,1,0,1,NULL,NULL,1),
(21,-1,'Car Mileage Log','Track the number of business miles that you put onto your car.',NULL,1,0,1,NULL,NULL,1),
(22,-1,'Business Meeting Log','Record your notes from business meetings and share them with your team.  Or keep them to yourself as CYA material.',NULL,1,0,1,NULL,NULL,1),
(23,-1,'Water Drinking Log','Hydrate, hydrate, hydrate.  Keep track of your daily water intake.  This log won\'t clutter your homepage with entries.  But it will give you powerful charts and graphs of yoru consumption.',NULL,1,0,1,NULL,NULL,0),
(24,-1,'Book Reading Log','Read a little.  Log a little.  Read a little.  Log a little.  A great way to capture your response to the concepts, plots and assumptions of the books you read.',NULL,1,0,1,NULL,NULL,1),
(25,-1,'Sleep Log','Track the number of hours that you sleep each night.  Often a change in sleep is the cause of other issues in life.',NULL,1,0,1,NULL,NULL,0),
(26,-1,'Body Weight Log','Chart your body weight.  See what diets work over time.  See how the seasons affect your weight.  By understanding your own personal weight trends you\'ll be in a much better position to control them.',NULL,1,0,1,NULL,NULL,0),
(27,-1,'Rockclimbing Log','Remember all of the excellent climbs that you\'ve done.',NULL,1,0,2,NULL,NULL,1),
(28,-1,'Bowel Movement Log','You can tell a lot from your bowel movements.  Just ask a doctor.  Better yet, log your bowel movements for a while and then take the charts and graphs to your doctor.  The Bowel Log allows you to keep track of color, consistency and other fields.',NULL,1,0,1,NULL,NULL,0),
(29,-1,'Urine Color Log','Keep track of your urine color to detect trends in vitamin absorbtion and general nutrition. ',NULL,1,0,1,NULL,NULL,1),
(30,-1,'Public Speaking Log','Sometimes public speaking is scary but by tracking it you can see your progress and gain comfort doing it.  Watch as the number of people in your audience grows.',NULL,1,0,1,NULL,NULL,1),
(31,-1,'Soccer Match Log','Store the results of those epic matches online.  Add pictures to properly capture the agony of defeat.',NULL,1,0,2,NULL,NULL,1),
(32,-1,'Timer Log','Use the timer log to time just about anything that you do repeatedly.  It has a simple time field that allows you to track hours, minutes and seconds.  Use it to see how much time you spend watching TV.  Or how much time you spend doing chores around the house.',NULL,1,0,1,NULL,NULL,0),
(33,-1,'Simple Rating Log','This simple log allows you to rate something from 1 to 10.',NULL,1,0,1,NULL,NULL,1);



/*
Table structure for megaoption
*/

CREATE TABLE `megaoption` (
  `megaoptionid` int(11) NOT NULL auto_increment,
  `logid` int(11) default NULL,
  `megafieldid` int(11) default NULL,
  `optiontext` varchar(50) NOT NULL default '0',
  `optiontextdisplayoverride` varchar(50) default NULL,
  `isdefault` int(11) default NULL,
  `isactive` int(11) default NULL,
  PRIMARY KEY  (`megaoptionid`),
  KEY `megaoptionid` (`megaoptionid`,`logid`,`megafieldid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*
Table structure for megavalue
*/

CREATE TABLE `megavalue` (
  `megavalueid` int(11) NOT NULL auto_increment,
  `megafieldid` int(11) default NULL,
  `eventid` int(11) default NULL,
  `megavalue` varchar(255) default NULL,
  `megavalueextended` varchar(255) default NULL,
  PRIMARY KEY  (`megavalueid`),
  KEY `megavalueid` (`megavalueid`,`megafieldid`,`eventid`),
  KEY `megafieldid` (`megafieldid`,`eventid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*
Table structure for message
*/

CREATE TABLE `message` (
  `messageid` int(11) NOT NULL auto_increment,
  `eventid` int(11) NOT NULL default '0',
  `messagedate` datetime NOT NULL default '0000-00-00 00:00:00',
  `messagefrom` varchar(50) default NULL,
  `message` longtext NOT NULL,
  `isapproved` int(11) NOT NULL default '0',
  `sizeinbytes` int(11) NOT NULL default '0',
  PRIMARY KEY  (`messageid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for mobile
*/

CREATE TABLE `mobile` (
  `mobileid` int(11) NOT NULL auto_increment,
  `xupsubno` varchar(255) NOT NULL default '',
  `accountid` int(11) NOT NULL default '0',
  PRIMARY KEY  (`mobileid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for pl
*/

CREATE TABLE `pl` (
  `plid` int(11) NOT NULL auto_increment,
  `plname` varchar(50) default NULL,
  `servername` varchar(50) default NULL,
  `plbasedomain` varchar(50) default NULL,
  `plmarketingtemplate` text,
  `plusertemplate` text,
  `titlebar` varchar(50) default NULL,
  `showadsmarketing` int(11) default NULL,
  `homelink` varchar(50) default NULL,
  `sectionhome` varchar(50) default NULL,
  `sectionhelp` varchar(50) default NULL,
  `sectionsignup` varchar(50) default NULL,
  `sectionsamples` varchar(50) default NULL,
  `sectiontour` varchar(50) default NULL,
  `comments` longtext,
  `islive` int(11) default '1',
  `issignupenabled` int(11) NOT NULL default '1',
  PRIMARY KEY  (`plid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table data for baseqlogger.pl
*/

INSERT INTO `pl` VALUES 
(1,'Default','','127.0.0.1','<html>\r\n<head>\r\n</head>\r\n<body  bgcolor=#ffffff link=\'#0000ff\' vlink=\'#000000\' text=\'#000000\' LEFTMARGIN=\'0\' TOPMARGIN=\'0\' MARGINWIDTH=\'0\' MARGINHEIGHT=\'0\'>\r\n\r\n\r\n<table cellspacing=\"0\" cellpadding=\"0\" width=100% border=\"0\">\r\n<tr>\r\n <td rowspan=\"2\" width=275 align=center><img src=\'../privatelabel/reger/images/reger-logo.gif\'></td>\r\n <td><img src=../images/clear.gif width=1 height=25></td>\r\n</tr>\r\n<tr>\r\n <td valign=bottom><$Nav.Bar$></td>\r\n</tr>\r\n</table>\r\n\r\n\r\n\r\n<table cellspacing=\"0\" cellpadding=\"0\" width=100% border=\"0\">\r\n<tr>\r\n <td valign=\"top\" bgcolor=#000000><img src=../images/clear.gif width=1 height=8></td>\r\n</tr>\r\n<tr>\r\n <td valign=\"top\" bgcolor=#ffcc00><$Header$></td>\r\n</tr>\r\n<tr>\r\n <td valign=\"top\" bgcolor=#000000><img src=../images/clear.gif width=1 height=1></td>\r\n</tr>\r\n</table>\r\n\r\n\r\n\r\n\r\n<table cellspacing=\"0\" width=100% cellpadding=\"0\" border=\"0\">\r\n<tr>\r\n <td valign=\"top\"><$Side.Column$></td>\r\n <td valign=\"top\" bgcolor=#000000 width=1><img src=../images/clear.gif width=1 height=1></td>\r\n <td valign=\"top\"><$Main.Body$></td>\r\n</tr>\r\n</table>\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n<table cellspacing=\"0\" cellpadding=\"0\" width=100% border=\"0\">\r\n<tr>\r\n <td valign=\"top\" bgcolor=#000000><img src=../images/clear.gif width=1 height=8></td>\r\n</tr>\r\n</table>\r\n\r\n\r\n</body>\r\n</html>\r\n','<html>\r\n<head>\r\n <title>Reger.com</title>\r\n</head>\r\n\r\n<body>\r\n\r\n<table cellpadding=0 cellspacing=0 border=0 width=100%>\r\n<tr>\r\n<td bgcolor=#ffffff align=right><$Banner$></td>\r\n</tr>\r\n\r\n<tr>\r\n<td><$Body$></td>\r\n</tr>\r\n</table>\r\n\r\n</body>\r\n</html>\r\n','Default',0,'index.log','howdy.','help please!?!?','wahoo. free signup. simple.','sample logs to spark your creativity.','the nickel tour.','',1,1);


/*
Table structure for pldeletearchive
*/

CREATE TABLE `pldeletearchive` (
  `pldeletearchiveid` int(11) NOT NULL auto_increment,
  `accountid` int(11) default NULL,
  `date` datetime default NULL,
  `oldplid` int(11) default NULL,
  `newplid` int(11) default NULL,
  PRIMARY KEY  (`pldeletearchiveid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for pleventtypeid
*/

CREATE TABLE `pleventtypeid` (
  `pleventtypeid` int(11) NOT NULL auto_increment,
  `plid` int(11) default NULL,
  `eventtypeid` int(11) default NULL,
  `priority` int(11) default NULL,
  PRIMARY KEY  (`pleventtypeid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table data for baseqlogger.pleventtypeid
*/

INSERT INTO `pleventtypeid` VALUES 
(49,1,3,48),
(50,1,1,47),
(51,1,12,46),
(54,1,11,44),
(55,1,13,43),
(56,1,14,42),
(57,1,8,41),
(58,1,16,40),
(59,1,4,39),
(61,1,2,38),
(62,1,5,36),
(63,1,15,35),
(64,1,10,34),
(65,1,18,33);


/*
Table structure for polarhrm
*/

CREATE TABLE `polarhrm` (
  `polarhrmid` int(11) NOT NULL auto_increment,
  `imageid` int(11) NOT NULL default '0',
  PRIMARY KEY  (`polarhrmid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for polarhrmdata
*/

CREATE TABLE `polarhrmdata` (
  `polarhrmdataid` int(11) NOT NULL auto_increment,
  `polarhrmid` int(11) NOT NULL default '0',
  `timeinseconds` int(11) default NULL,
  `heartrate` int(11) default NULL,
  `speed` double default NULL,
  `cadence` int(11) default NULL,
  `altitude` int(11) default NULL,
  `power` int(11) default NULL,
  `leftpowerbalance` int(11) default NULL,
  `pedalingindex` int(11) default NULL,
  PRIMARY KEY  (`polarhrmdataid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for scheduler
*/

CREATE TABLE `scheduler` (
  `schedulerid` int(11) NOT NULL auto_increment,
  `masterthreadid` int(11) default NULL,
  `task` varchar(255) default NULL,
  `lastrun` datetime default NULL,
  `timesrun` int(11) default NULL,
  `comment` varchar(255) default NULL,
  PRIMARY KEY  (`schedulerid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for search
*/

CREATE TABLE `search` (
  `searchid` int(11) NOT NULL auto_increment,
  `accountid` int(11) default NULL,
  `searchstring` varchar(50) default NULL,
  `datetime` datetime default NULL,
  PRIMARY KEY  (`searchid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table structure for template
*/

CREATE TABLE `template` (
  `templateid` int(11) NOT NULL auto_increment,
  `templatemainbody` longtext,
  `templateentry` longtext,
  `templatename` longtext,
  `templateauthor` longtext,
  `templatestatus` int(11) NOT NULL default '1',
  `thumbnail` varchar(50) default NULL,
  `showwithsignup` int(11) default '0',
  PRIMARY KEY  (`templateid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


/*
Table data for baseqlogger.template
*/

INSERT INTO `template` VALUES 
(2,'<html>\r\n<head>\r\n<title><$Site.Name$> <$Entry.Title$></title>\r\n<style>\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:25px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#6666666;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 2px;\r\n          background-color: #F8F8FF;\r\n	      width: 100%}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 2px;\r\n          background-color: #667F99;\r\n	  width: 100%}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #cccccc; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {background-color: #667F99;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #cccccc; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {background-color: #F8F8FF;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #334C66; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{background-color: #99B2CC;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{background-color: #334C66;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #999999; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{background-color: #ffffff;\r\n	      FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{border: solid #334C66 1px; \r\n          padding: 0px;\r\n          background-color: #667F99;\r\n	      width: 100%}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n		  \r\n</style>\r\n\r\n\r\n\r\n\r\n<style type=\"text/css\">\r\n<!--\r\n.main {COLOR: #334C66; FONT-FAMILY: verdana, arial, helvetica, sans-serif; FONT-SIZE: 10px; TEXT-DECORATION: none}\r\n\r\n.little {COLOR: #99B2CC; FONT-FAMILY: verdana, arial, helvetica, sans-serif; FONT-SIZE: 9px; TEXT-DECORATION: none}\r\n\r\n.heading {color: #334C66; border-bottom: 1px #334C66 solid; FONT-FAMILY: verdana, arial, helvetica, sans-serif; font-size: 12px; text-decoration: none; font-weight: bold; background-color: #99B2CC}\r\n\r\n.tablish {border-top: 1px #334C66 solid; border-right: 1px #334C66 solid; border-bottom: 1px #334C66 solid; border-left: 1px #334C66 solid; color: #4D3366; background-color: #F8F8FF }\r\n\r\n.headish {border-top: 1px #4D3366 solid; border-right: 1px #4D3366 solid; border-bottom: 1px #4D3366 solid; border-left: 1px #4D3366 solid; background-color: #334C66; color: #99B2CC; FONT-FAMILY: verdana, arial, helvetica, sans-serif; font-size: 24px; text-decoration: none; text-transform: lowercase; font-weight: bold }\r\n\r\n\r\n-->\r\n</style>\r\n</head>\r\n\r\n<body bgcolor=\"#334C66\" leftmargin=0 rightmargin=0 topmargin=0>\r\n<table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#667F99\">\r\n  <tr> \r\n    <td align=\"left\" class=\"headish\"><p><$Site.Name$> :: <$Log.Name$></p?</td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n     <table width=\"100%\" cellpadding=\"0\" cellspacing=\"10\">\r\n      <tr valign=\"top\">\r\n       <td width=\"65%\">    		\r\n			\r\n			<$Main.Body$>\r\n       </td>\r\n       <td width=\"35%\" class=\"tablish\" valign=top>\r\n	   		<$Navbar.Vertical$>\r\n			<br>\r\n        	<$Side.Column$>\r\n       </td>\r\n      </tr>\r\n     </table>\r\n    </td>\r\n  </tr>\r\n  <tr> \r\n    <td align=\"right\" class=\"headish\"><p class=\"little\"></p></td>\r\n  </tr>\r\n </table>\r\n</body>\r\n</html>','<table width=\"100%\" class=\"tablish\" cellpadding=\"4\" cellspacing=\"0\"> \r\n         <tr class=\"heading\"> \r\n          <td><a href=<$Logentry.Url$>> <$Logentry.Title$></a></td>\r\n         </tr>\r\n         <tr class=\"main\"> \r\n          <td><p><$Ago.Text$> :: <$Log.Name$></p>\r\n		  <p><$Logentry.Body$></p>\r\n          <p class=\"little\"><$Messages.Count$> Messages | <$Images.Count$> Images | <$Logentry.Datetime.Expanded$> | <a href=<$Logentry.Url$>>More >></a></p>\r\n           </td>\r\n         </tr>\r\n</table>','Blue is for Boys','kerykes',1,'blueisforboys.gif',1),
(3,'<html>\r\n<head>\r\n  <title><$Site.Name$> <$Entry.Title$></title>\r\n\r\n<style>\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:25px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#6666666;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%;background-color: #cccccc;}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 2px;\r\n          background-color: #cccccc;\r\n	      width: 100%}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 2px;\r\n          background-color: #0099cc;\r\n	  width: 100%}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {background-color: #0099cc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #334C66; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{background-color: #999999;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{background-color: #ffffff;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{background-color: #ffffff;\r\n	      FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{padding: 0px;\r\n          background-color: #cccccc;\r\n	      width: 100%}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n		  \r\n</style>\r\n\r\n</head>\r\n<body bgcolor=\"#999999\" text=\"#000000\" link=\"#0000ff\" vlink=\"#3300cc\">\r\n<center>\r\n<table cellpadding=0 cellspacing=0 border=0 bgcolor=#000000 width=95%><tr><td>\r\n<table cellpadding=3 cellspacing=2 border=0 width=100%>\r\n\r\n<tr>\r\n<td colspan=3 valign=bottom align=right bgcolor=\"#0099cc\">\r\n<br><br><br><font face=arial size=+3><$Site.Name$></font>\r\n</td>\r\n</tr>\r\n\r\n<tr>\r\n<td valign=top bgcolor=\"#cccccc\" width=150>\r\n<$Navbar.Vertical$>\r\n</td>\r\n<td valign=top bgcolor=#ffffff>\r\n<$Main.Body$>\r\n</td>\r\n<td valign=top bgcolor=#cccccc width=200 align=center>\r\n<$Side.Column$>\r\n</td>\r\n</tr>\r\n\r\n</table></td></tr></table>\r\n</center>\r\n</body>\r\n</html>','<p>\r\n<a href=<$Logentry.Url$>><font face=arial size=+1><$Logentry.Title$></font></a>\r\n<br>\r\n<font face=arial size=-1><strong><$Ago.Text$> :: <$Log.Name$></strong></font>\r\n<br>\r\n<font face=arial size=-1><$Logentry.Body$></font>\r\n<br> \r\n<font face=arial size=-2><$Logentry.Datetime.Expanded$> | <$Messages.Count$> Messages | <$Images.Count$> Images</font>','Three Column Rainy Day','qlogger.com',1,'threecolumnrainyday.gif',1),
(4,'<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n<html>\r\n<head>\r\n<style type=\"text/css\">\r\n<!--\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:25px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#6666666;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 2px;\r\n          background-color: #cccccc;\r\n	      width: 100%}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 2px;\r\n          background-color: #333333;\r\n	  width: 100%}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #ffffff; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {background-color: #333333;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #ffffff; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{background-color: #666666;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{background-color: #ffffff;\r\n	      FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{border: solid #ffffff 1px; \r\n          padding: 0px;\r\n          background-color: #ffffff;\r\n	      width: 100%}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n--> \r\n</style>\r\n\r\n	<title><$Site.Name$> <$Entry.Title$></title>\r\n</head>\r\n<body bgcolor=#ffffff LEFTMARGIN=\'0\' TOPMARGIN=\'0\' MARGINWIDTH=\'0\' MARGINHEIGHT=\'0\'>\r\n<font face=arial size=+3><$Site.Name$></font>\r\n<br>\r\n<table cellpadding=0 cellspacing=0 border=0 width=100%>\r\n<td valign=top width=150>\r\n<$Navbar.Vertical$>\r\n</td>\r\n\r\n<td valign=top nowrap>  </td>\r\n\r\n<td valign=top>\r\n<$Main.Body$>\r\n</td>\r\n\r\n<td valign=top nowrap>  </td>\r\n\r\n<td valign=top width=200>\r\n<$Side.Column$>\r\n</td>\r\n</tr>\r\n</table>\r\n</body>\r\n</html>','<p>\r\n<a href=<$Logentry.Url$>><font face=arial size=+1><$Logentry.Title$></font></a>\r\n<br>\r\n<font face=arial size=-1><strong><$Ago.Text$> :: <$Log.Name$></strong></font>\r\n<br>\r\n<font face=arial size=-1><$Logentry.Body$></font>\r\n<br> \r\n<font face=arial size=-2><$Logentry.Datetime.Expanded$> | <$Messages.Count$> Messages | <$Images.Count$> Images</font>','Simple Grey Three Column','qlogger.com',1,'simplegreythreecolumn.gif',1),
(5,'<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n<html>\r\n<head>\r\n<style type=\"text/css\">\r\n<!--\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:25px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{border: dashed #000000 1px; width: 100%}\r\n\r\n/* The table that houses your main log navigation. */\r\n.logentrylist{border: dashed #000000 1px; width: 100%}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 2px;\r\n          background-color: #ffffff;\r\n	      width: 100%}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 2px;\r\n          background-color: #ffffff;\r\n	  width: 100%}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {border: dashed #000000 1px; width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {background-color: #ffffff;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {background-color: #ffffff;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #ffffff; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{background-color: #ffffff;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{background-color: #ffffff;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{background-color: #ffffff;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{background-color: #ffffff;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{background-color: #ffffff;\r\n	      FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{border: dashed #000000 1px;\r\n          padding: 0px;\r\n          background-color: #ffffff;\r\n	      width: 100%}\r\n.caffeinecell{background-color: #ffffff;}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n--> \r\n</style>\r\n\r\n	<title><$Site.Name$> <$Entry.Title$></title>\r\n</head>\r\n<body bgcolor=#ffffff LEFTMARGIN=\'0\' TOPMARGIN=\'0\' MARGINWIDTH=\'0\' MARGINHEIGHT=\'0\'>\r\n<font face=arial size=+3 color=#000000><$Site.Name$></font>\r\n<br>\r\n<table cellpadding=5 cellspacing=0 border=0 width=100%>\r\n<td valign=top width=150>\r\n<$Navbar.Vertical$>\r\n</td>\r\n\r\n<td valign=top nowrap>  </td>\r\n\r\n<td valign=top>\r\n<$Main.Body$>\r\n</td>\r\n\r\n<td valign=top nowrap>  </td>\r\n\r\n<td valign=top width=200>\r\n<$Side.Column$>\r\n</td>\r\n</tr>\r\n</table>\r\n</body>\r\n</html>','<p class=logentrylist>\r\n<a href=<$Logentry.Url$>><font face=arial size=+1 color=#000000><$Logentry.Title$></font></a>\r\n<br>\r\n<font face=arial size=-1 color=#000000><strong><$Ago.Text$> :: <$Log.Name$></strong></font>\r\n<br>\r\n<font face=arial size=-1 color=#000000><$Logentry.Body$></font>\r\n<br> \r\n<font face=arial size=-2 color=#000000><$Logentry.Datetime.Expanded$> | <$Messages.Count$> Messages | <$Images.Count$> Images</font>\r\n</p>','Simple Dotted Boxes','qlogger.com',1,'simpledottedboxes.gif',1),
(13,'<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n<html>\r\n<head>\r\n<style type=\"text/css\">\r\n<!--\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:25px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#6666666;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 2px;\r\n          background-color: #b0c4de;\r\n	      width: 100%}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 2px;\r\n          background-color: #660066;\r\n	  width: 100%}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #ffffff; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {background-color: #660066;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #ffffff; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {background-color: #b0c4de;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{background-color: #666666;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{background-color: #b0c4de;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{background-color: #ffffff;\r\n	      FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{border: solid #ffffff 1px; \r\n          padding: 0px;\r\n          background-color: #ffffff;\r\n	      width: 100%}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n--> \r\n</style>\r\n\r\n	<title><$Site.Name$> <$Entry.Title$></title>\r\n</head>\r\n<body bgcolor=#ffffff LEFTMARGIN=\'0\' TOPMARGIN=\'0\' MARGINWIDTH=\'0\' MARGINHEIGHT=\'0\'>\r\n<font face=arial size=+3><$Site.Name$></font>\r\n<br>\r\n<table cellpadding=0 cellspacing=0 border=0 width=100%>\r\n<td valign=top width=150>\r\n<$Navbar.Vertical$>\r\n</td>\r\n\r\n<td valign=top nowrap>  </td>\r\n\r\n<td valign=top>\r\n<$Main.Body$>\r\n</td>\r\n\r\n<td valign=top nowrap>  </td>\r\n\r\n<td valign=top width=200>\r\n<$Side.Column$>\r\n</td>\r\n</tr>\r\n</table>\r\n</body>\r\n</html>','<p>\r\n<a href=<$Logentry.Url$>><font face=arial size=+1><$Logentry.Title$></font></a>\r\n<br>\r\n<font face=arial size=-1><strong><$Ago.Text$> :: <$Log.Name$></strong></font>\r\n<br>\r\n<font face=arial size=-1><$Logentry.Body$></font>\r\n<br> \r\n<font face=arial size=-2><$Logentry.Datetime.Expanded$> | <$Messages.Count$> Messages | <$Images.Count$> Images</font>','Simple Lavender','qlogger.com',1,'simplelavender.gif',1),
(14,'<html>\r\n<head>\r\n	<title><$Site.Name$> <$Entry.Title$></title>\r\n	\r\n<style type=\"text/css\">\r\n<!--\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:15px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 0px;\r\n          background-color: #333333;}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 0px;\r\n          background-color: #333333;}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #ffffff; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #ffffff; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {background-color: #e6e6e6;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{background-color: #e6e6e6;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{background-color: #ffffff;\r\n	      FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{border: solid #ffffff 1px; \r\n          padding: 0px;\r\n          background-color: #ffffff;\r\n	      width: 100%}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n\r\n.navcolumn{border-left: dashed #000000 1px;}\r\n\r\n--> \r\n</style>\r\n\r\n\r\n	\r\n</head>\r\n\r\n<body bgcolor=#33ff00 LEFTMARGIN=\'0\' TOPMARGIN=\'0\' MARGINWIDTH=\'0\' MARGINHEIGHT=\'0\'>\r\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=100%>\r\n<tr>\r\n    <td valign=bottom align=left width=154><img src=\"images/template/templatename/asterisk/asterisk-top.gif\" width=\"154\" height=\"82\" alt=\"\" border=\"0\"></td>\r\n    <td colspan=\"2\" valign=bottom><font face=arial size=+3 color=#000000><$Site.Name$></font></td>\r\n</tr>\r\n<tr>\r\n    <td bgcolor=#333333><img src=\"images/template/templatename/asterisk/asterisk-middle.gif\" width=\"154\" height=\"24\" alt=\"\" border=\"0\"></td>\r\n    <td colspan=\"2\" bgcolor=#333333><$Navbar.Horizontal$></td>\r\n</tr>\r\n<tr>\r\n    <td valign=top bgcolor=#ffffff><img src=\"images/template/templatename/asterisk/asterisk-bottom.gif\" width=\"154\" height=\"49\" alt=\"\" border=\"0\"></td>\r\n    <td bgcolor=#ffffff><img src=\"images/clear.gif\" width=\"1\" height=\"1\" alt=\"\" border=\"0\"><font face=arial size=-1 color=#cccccc><strong><$Log.Name$></strong></font></td>\r\n    <td class=navcolumn bgcolor=#e6e6e6 rowspan=\"2\" width=25% valign=top><$Side.Column$></td>\r\n</tr>\r\n<tr>\r\n    <td bgcolor=#ffffff valign=top><img src=\"images/clear.gif\" width=\"1\" height=\"1\" alt=\"\" border=\"0\"></td>\r\n    <td bgcolor=#ffffff><$Main.Body$></td>\r\n</tr>\r\n<tr>\r\n    <td colspan=\"3\" bgcolor=#333333><img src=\"images/clear.gif\" width=\"1\" height=\"10\" alt=\"\" border=\"0\"></td>\r\n</tr>\r\n<tr>\r\n    <td colspan=\"3\"></td>\r\n</tr>\r\n</table>\r\n\r\n\r\n\r\n</body>\r\n</html>','<table border=0 cellpadding=3>\r\n<tr>\r\n<td valign=top>\r\n<a href=<$Logentry.Url$>><img src=\"images/template/templatename/asterisk/asterisk.gif\" alt=\"\" border=\"0\" align=middle></a>\r\n</td>\r\n<td valign=top>\r\n<a href=<$Logentry.Url$>><font face=arial size=+1 color=\"#339900\"><strong><$Logentry.Title$></strong></font></a>\r\n<br>\r\n<font face=arial size=-1 color=#000000><strong><$Ago.Text$> :: <$Log.Name$></strong></font>\r\n<br>\r\n<font face=arial size=-1 color=#000000><$Logentry.Body$></font>\r\n<br> \r\n<font face=arial size=-2 color=#000000><$Logentry.Datetime.Expanded$> | <$Messages.Count$> Messages | <$Images.Count$> Images</font>\r\n</td>\r\n</tr>\r\n</table>','Asterisk Green','qlogger.com',1,'asteriskgreen.gif',1),
(15,'<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n<html>\r\n<head>\r\n<style type=\"text/css\">\r\n<!--\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:25px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 2px;\r\n	      width: 100%}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 2px;\r\n	  width: 100%}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{padding: 0px;\r\n	      width: 100%}\r\n.caffeinecell{}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n\r\nbody { background: url(\"images/template/tiledbgimages/brain.jpg\"); background-repeat: no-repeat; background-color: #ffffff; }\r\n\r\n\r\n--> \r\n</style>\r\n\r\n	<title><$Site.Name$> <$Entry.Title$></title>\r\n</head>\r\n<body bgcolor=#ffffff LEFTMARGIN=\'0\' TOPMARGIN=\'0\' MARGINWIDTH=\'0\' MARGINHEIGHT=\'0\'>\r\n<font face=arial size=+3 color=#000000><$Site.Name$></font>\r\n<br>\r\n<table cellpadding=0 cellspacing=0 border=0 width=750>\r\n<td valign=top width=150>\r\n<$Navbar.Vertical$>\r\n</td>\r\n\r\n<td valign=top nowrap>  </td>\r\n\r\n<td valign=top>\r\n<$Main.Body$>\r\n</td>\r\n\r\n<td valign=top nowrap>  </td>\r\n\r\n<td valign=top width=200>\r\n<$Side.Column$>\r\n</td>\r\n</tr>\r\n</table>\r\n</body>\r\n</html>','<p>\r\n<a href=<$Logentry.Url$>><font face=arial size=+1 color=#000000><$Logentry.Title$></font></a>\r\n<br>\r\n<font face=arial size=-1 color=#000000><strong><$Ago.Text$> :: <$Log.Name$></strong></font>\r\n<br>\r\n<font face=arial size=-1 color=#000000><$Logentry.Body$></font>\r\n<br> \r\n<font face=arial size=-2 color=#000000><$Logentry.Datetime.Expanded$> | <$Messages.Count$> Messages | <$Images.Count$> Images</font>','Smarty Pants','qlogger.com',1,'smartypants.gif',1),
(16,'<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n<html>\r\n<head>\r\n<style type=\"text/css\">\r\n<!--\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:25px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 2px;\r\n	      width: 100%}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 2px;\r\n	  width: 100%}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{padding: 0px;\r\n	      width: 100%}\r\n.caffeinecell{}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n\r\nbody { background: url(\"images/template/tiledbgimages/ear.jpg\"); background-repeat: no-repeat; background-color: #ffffff; }\r\n\r\n\r\n--> \r\n</style>\r\n\r\n	<title><$Site.Name$> <$Entry.Title$></title>\r\n</head>\r\n<body bgcolor=#ffffff LEFTMARGIN=\'0\' TOPMARGIN=\'0\' MARGINWIDTH=\'0\' MARGINHEIGHT=\'0\'>\r\n<font face=arial size=+3 color=#000000><$Site.Name$></font>\r\n<br>\r\n<table cellpadding=0 cellspacing=0 border=0 width=750>\r\n<td valign=top width=150>\r\n<$Navbar.Vertical$>\r\n</td>\r\n\r\n<td valign=top nowrap>  </td>\r\n\r\n<td valign=top>\r\n<$Main.Body$>\r\n</td>\r\n\r\n<td valign=top nowrap>  </td>\r\n\r\n<td valign=top width=200>\r\n<$Side.Column$>\r\n</td>\r\n</tr>\r\n</table>\r\n</body>\r\n</html>','<p>\r\n<a href=<$Logentry.Url$>><font face=arial size=+1 color=#000000><$Logentry.Title$></font></a>\r\n<br>\r\n<font face=arial size=-1 color=#000000><strong><$Ago.Text$> :: <$Log.Name$></strong></font>\r\n<br>\r\n<font face=arial size=-1 color=#000000><$Logentry.Body$></font>\r\n<br> \r\n<font face=arial size=-2 color=#000000><$Logentry.Datetime.Expanded$> | <$Messages.Count$> Messages | <$Images.Count$> Images</font>','Listen to Me','qlogger.com',1,'listentome.gif',1),
(17,'<html>\r\n<head>\r\n  <title><$Site.Name$> <$Entry.Title$></title>\r\n\r\n<style>\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:25px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#666666;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%;background-color: #cccccc;}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 2px;\r\n          background-color: #cccccc;\r\n	      width: 100%}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 2px;\r\n          background-color: #ffcc00;\r\n	  width: 100%}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {background-color: #ffcc00;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #334C66; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{background-color: #999999;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{background-color: #ffffcc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{background-color: #ffffff;\r\n	      FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{padding: 0px;\r\n          background-color: #cccccc;\r\n	      width: 100%}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n		  \r\n</style>\r\n\r\n</head>\r\n<body bgcolor=\"#333333\" text=\"#000000\" link=\"#0000ff\" vlink=\"#0000ff\">\r\n<center>\r\n<table cellpadding=0 cellspacing=0 border=0 bgcolor=#000000 width=95%><tr><td>\r\n<table cellpadding=3 cellspacing=2 border=0 width=100%>\r\n\r\n<tr>\r\n<td colspan=3 valign=bottom align=right bgcolor=\"#ffcc00\">\r\n<br><br><br><font face=arial size=+3><$Site.Name$></font>\r\n</td>\r\n</tr>\r\n\r\n<tr>\r\n<td valign=top bgcolor=\"#cccccc\" width=150>\r\n<$Navbar.Vertical$>\r\n</td>\r\n<td valign=top bgcolor=#ffffff>\r\n<$Main.Body$>\r\n</td>\r\n<td valign=top bgcolor=#cccccc width=200 align=center>\r\n<$Side.Column$>\r\n</td>\r\n</tr>\r\n\r\n</table></td></tr></table>\r\n</center>\r\n</body>\r\n</html>','<p>\r\n<a href=<$Logentry.Url$>><font face=arial size=+1><$Logentry.Title$></font></a>\r\n<br>\r\n<font face=arial size=-1><strong><$Ago.Text$> :: <$Log.Name$></strong></font>\r\n<br>\r\n<font face=arial size=-1><$Logentry.Body$></font>\r\n<br> \r\n<font face=arial size=-2><$Logentry.Datetime.Expanded$> | <$Messages.Count$> Messages | <$Images.Count$> Images</font>','Three Column Yellow on Grey','qlogger.com',1,'threecolumnyellowongrey.gif',1),
(18,'<html><head><title><$Site.Name$> <$Entry.Title$></title>\r\n\r\n<style type=\"text/css\">\r\n<!--\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:25px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#666666;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{border: solid #006699 5px;\r\n           padding: 2px;\r\n          background-color: #cccccc;}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{border: solid #006699 5px; padding: 2px;\r\n          background-color: #333333;}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #ffffff; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {border: solid #006699 5px; width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {background-color: #006699;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #ffffff; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {background-color: #ffffff;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{background-color: #666666;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{background-color: #ffffff;\r\n	      FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{border: solid #ffffff 1px; \r\n          padding: 0px;\r\n          background-color: #ffffff;\r\n	      width: 100%}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n--> \r\n</style>\r\n\r\n\r\n</head>\r\n<body bgcolor=#ffffff link=\'#0000ff\' vlink=\'#000000\' text=\'#000000\' LEFTMARGIN=\'0\' TOPMARGIN=\'0\' MARGINWIDTH=\'0\' MARGINHEIGHT=\'0\'>\r\n<table cellpadding=0 cellspacing=0 width=100% border=0>\r\n\r\n<tr><td colspan=3 valign=top><font face=arial size=+3><$Site.Name$></font><br><$Navbar.Horizontal$></td></tr>\r\n\r\n<tr><td valign=top><br><$Main.Body$></td><td valign=top nowrap>   </td><td valign=top width=200><br><font face=arial size=+2><$Log.Name$></font><br><$Side.Column$></td></tr>\r\n\r\n</table>\r\n</body></html>','<!-- Begin Entry --><table width=100% border=0 cellpadding=0 cellspacing=0><tr><td rowspan=2 valign=top width=92><$Ago.Graphic.1$></td><td width=4 rowspan=2 valign=top background=images/box/upperleftcornerbg.gif><img src=images/box/upperleftcorner.gif width=4 height=24></td><td width=100% background=images/box/tophorizontalbar.gif><!-- this gif must be (widthoftable-92) --><img src=images/box/clear.gif width=100% height=4></td><td width=6 rowspan=2 valign=top background=images/box/rightverticalbar.gif><img src=images/box/upperrightcorner.gif width=6 height=24></td></tr><tr><td background=images/box/date.gif valign=middle><img src=images/box/clear.gif width=1 height=20 align=right><img src=images/box/clear.gif width=1 height=13><font size=-2 face=arial><$Logentry.Datetime.Expanded$> :: <$Log.Name$></font></td></tr><tr><td rowspan=5><img src=images/box/leftspacer.gif width=92 height=98></td><td rowspan=4 background=images/box/leftverticalbar.gif><img src=images/box/clear.gif width=4 height=1></td><td background=images/box/topspacer.gif><img src=images/box/clear.gif width=1 height=1></td><td rowspan=4 background=images/box/rightverticalbar.gif><img src=images/box/clear.gif width=6 height=1></td></tr><tr><td background=images/box/title.gif><!-- title --><font size=-1 face=arial><b><a href=<$Logentry.Url$>><$Logentry.Title$></a></b></font><br><img src=images/clear.gif width=10 height=1><font face=arial size=-2></font><br><img src=images/clear.gif width=10 height=1><font face=arial size=-2></font><br><img src=images/box/clear.gif width=6 height=2></td></tr><tr><td background=images/box/bottomspacer.gif><img src=images/box/clear.gif width=1 height=1></td></tr><tr><td><!-- start main content --><font size=-1 face=arial><$Logentry.Body$></font><br><br><font face=arial size=-2><$Messages.Count$> Messages | <$Images.Count$> Images</font><!-- end main content --></td></tr><tr><td valign=top background=images/box/bottomleftcornerbg.gif><img src=images/box/bottomleftcorner.gif width=4 height=6></td><td background=images/box/bottomhorizontalbar.gif><img src=images/box/clear.gif width=1 height=6></td><td valign=top><img src=images/box/bottomrightcorner.gif width=6 height=6></td></tr></table><!-- End Entry -->','Hideously Ugly Blue Boxes','qlogger.com',1,'hideouslyuglyblueboxes.gif',1),
(20,' \r\n<html>\r\n   <head>\r\n      <title><$Site.Name$> <$Entry.Title$></title>\r\n   \r\n\r\n<style type=\"text/css\">\r\n<!--\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:25px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 2px;\r\n          background-color: #cccccc;}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 2px;\r\n          background-color: #333333;}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #ffffff; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {background-color: #333333;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #ffffff; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{background-color: #666666;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{background-color: #ffffff;\r\n	      FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{border: solid #ffffff 1px; \r\n          padding: 0px;\r\n          background-color: #ffffff;\r\n	      width: 100%}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n--> \r\n</style>\r\n\r\n\r\n\r\n      <style type=\"text/css\">\r\n\r\n	body\r\n	{background-color:#000000;\r\n	margin:0px;\r\n	text-align:center;\r\n	font-family:verdana,sans-serif;\r\n	color:#999999;\r\n	font-size:10px;}\r\n\r\n	a\r\n	{color:#0000ff;\r\n	text-decoration:none}\r\n\r\n	p.title\r\n	{color:#8fa1b3;\r\n	text-align:left;\r\n	font-family:arial narrow, arial, sans-serif;\r\n	font-size:22px; \r\n	margin:0px; \r\n	padding:0px;}\r\n\r\n	p.navheader	\r\n	{font-size:12px; \r\n	font-weight:bold; \r\n	border-bottom: 2px solid #fff; \r\n	color:#fff; \r\n	margin:2px; \r\n	padding:0px;}\r\n\r\n	p.date\r\n	{font-size:14px;\r\n	font-wight:bold;\r\n	border-bottom: 2px solid #fff;\r\n	color:#fff;\r\n	margin:3px;\r\n	padding:0px;}\r\n\r\n	p.signature\r\n	{font-size:10px;\r\n	width:100px;\r\n	text-align:right;\r\n	color:#fff;}\r\n\r\n	\r\n	\r\n\r\n      </style>\r\n\r\n   </head>\r\n\r\n   <body>\r\n\r\n<center>\r\n<font face=arial size=+3><$Site.Name$></font>\r\n</center>\r\n<br>\r\n<table cellpadding=0 cellspacing=0 border=0 bgcolor=#000000 width=95%><tr><td>\r\n<table cellpadding=0 cellspacing=1  width=100% border=0>\r\n\r\n<tr>\r\n<td bgcolor=\"#ffcc00\">\r\n<font color=#ffcc00>.</font>\r\n</td>\r\n</tr>\r\n\r\n<tr>\r\n<td bgcolor=#ffffcc>\r\n\r\n<!-- Start Center Inside Table -->\r\n<table cellpadding=0 cellspacing=0 width=100% border=0 bgcolor=#ffffcc><tr><td>\r\n<table cellpadding=0 cellspacing=3 width=100% border=0>\r\n<tr>\r\n<td>\r\n<!-- Start Content Table -->\r\n<table cellpadding=0 cellspacing=0 width=100% border=0 bgcolor=#000000><tr><td>\r\n<table cellpadding=0 cellspacing=1 width=100% border=0>\r\n<tr>\r\n<td valign=top bgcolor=#cccccc width=200>\r\n<$Navbar.Vertical$>\r\n<$Side.Column$>\r\n</td>\r\n<td valign=top bgcolor=#ffffff>\r\n<table cellpadding=5 cellspacing=0 border=0><tr><td>\r\n<$Main.Body$>\r\n</td></tr></table>\r\n                                                                                                                       \r\n</td>\r\n</tr>\r\n</table>\r\n</td></tr></table>\r\n<!-- End Content Table -->\r\n</td>\r\n</tr>\r\n</table>	\r\n</td></tr></table>\r\n<!-- End Center Inside Table -->\r\n</td>\r\n</tr>\r\n\r\n\r\n</table>	\r\n</td></tr></table>\r\n\r\n   </body>\r\n</html>','<p>\r\n<a href=<$Logentry.Url$>><font face=arial size=+1><$Logentry.Title$></font></a>\r\n<br>\r\n<font face=arial size=-1><strong><$Ago.Text$> :: <$Log.Name$></strong></font>\r\n<br>\r\n<font face=arial size=-1><$Logentry.Body$></font>\r\n<br> \r\n<font face=arial size=-2><$Logentry.Datetime.Expanded$> | <$Messages.Count$> Messages | <$Images.Count$> Images</font>','Gold and Black Plain Text','qlogger.com',1,'goldandblackplaintext.gif',1),
(21,'<html>\r\n   <head>\r\n      <title><$Site.Name$> <$Entry.Title$></title>\r\n   \r\n\r\n<style type=\"text/css\">\r\n<!--\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:25px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 2px;\r\n          background-color: #cccccc;}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 2px;\r\n          background-color: #333333;}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #ffffff; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {background-color: #333333;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #ffffff; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{background-color: #666666;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{background-color: #ffffff;\r\n	      FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{border: solid #ffffff 1px; \r\n          padding: 0px;\r\n          background-color: #ffffff;\r\n	      width: 100%}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n--> \r\n</style>\r\n\r\n\r\n\r\n      <style type=\"text/css\">\r\n\r\n	body\r\n	{background-color:#ffffff;\r\n	margin:0px;\r\n	text-align:center;\r\n	font-family:verdana,sans-serif;\r\n	color:#999999;\r\n	font-size:10px;}\r\n\r\n	a\r\n	{color:#0000ff;\r\n	text-decoration:none}\r\n\r\n	p.title\r\n	{color:#8fa1b3;\r\n	text-align:left;\r\n	font-family:arial narrow, arial, sans-serif;\r\n	font-size:22px; \r\n	margin:0px; \r\n	padding:0px;}\r\n\r\n	p.navheader	\r\n	{font-size:12px; \r\n	font-weight:bold; \r\n	border-bottom: 2px solid #fff; \r\n	color:#fff; \r\n	margin:2px; \r\n	padding:0px;}\r\n\r\n	p.date\r\n	{font-size:14px;\r\n	font-wight:bold;\r\n	border-bottom: 2px solid #fff;\r\n	color:#fff;\r\n	margin:3px;\r\n	padding:0px;}\r\n\r\n	p.signature\r\n	{font-size:10px;\r\n	width:100px;\r\n	text-align:right;\r\n	color:#fff;}\r\n\r\n	\r\n	\r\n\r\n      </style>\r\n\r\n   </head>\r\n\r\n   <body bgcolor=#ffffff>\r\n\r\n<center>\r\n<font face=arial size=+3 color=#000000><$Site.Name$></font>\r\n</center>\r\n<br>\r\n<table cellpadding=0 cellspacing=0 border=0 bgcolor=#000000 width=95%><tr><td>\r\n<table cellpadding=0 cellspacing=1  width=100% border=0>\r\n\r\n<tr>\r\n<td bgcolor=\"#ffcc00\">\r\n<font color=#ffcc00>.</font>\r\n</td>\r\n</tr>\r\n\r\n<tr>\r\n<td bgcolor=#ffffcc>\r\n\r\n<!-- Start Center Inside Table -->\r\n<table cellpadding=0 cellspacing=0 width=100% border=0 bgcolor=#ffffcc><tr><td>\r\n<table cellpadding=0 cellspacing=3 width=100% border=0>\r\n<tr>\r\n<td>\r\n<!-- Start Content Table -->\r\n<table cellpadding=0 cellspacing=0 width=100% border=0 bgcolor=#000000><tr><td>\r\n<table cellpadding=0 cellspacing=1 width=100% border=0>\r\n<tr>\r\n<td valign=top bgcolor=#cccccc width=200>\r\n<$Navbar.Vertical$>\r\n</td>\r\n<td valign=top bgcolor=#ffffff>\r\n<table cellpadding=5 cellspacing=0 border=0><tr><td>\r\n<$Main.Body$>\r\n</td></tr></table>\r\n</td>\r\n<td valign=top bgcolor=#cccccc width=200>\r\n<$Side.Column$>\r\n</td>\r\n</tr>\r\n</table>\r\n                                                                                                                       \r\n</td>\r\n</tr>\r\n</table>\r\n</td></tr></table>\r\n<!-- End Content Table -->\r\n</td>\r\n</tr>\r\n</table>	\r\n</td></tr></table>\r\n<!-- End Center Inside Table -->\r\n</td>\r\n</tr>\r\n\r\n\r\n</table>	\r\n</td></tr></table>\r\n\r\n   </body>\r\n</html>','<!-- Begin Entry --><table width=100% border=0 cellpadding=0 cellspacing=0><tr><td rowspan=2 valign=top width=92><$Ago.Graphic.1$></td><td width=4 rowspan=2 valign=top background=images/box/upperleftcornerbg.gif><img src=images/box/upperleftcorner.gif width=4 height=24></td><td width=100% background=images/box/tophorizontalbar.gif><!-- this gif must be (widthoftable-92) --><img src=images/box/clear.gif width=100% height=4></td><td width=6 rowspan=2 valign=top background=images/box/rightverticalbar.gif><img src=images/box/upperrightcorner.gif width=6 height=24></td></tr><tr><td background=images/box/date.gif valign=middle><img src=images/box/clear.gif width=1 height=20 align=right><img src=images/box/clear.gif width=1 height=13><font size=-2 face=arial><$Logentry.Datetime.Expanded$> :: <$Log.Name$></font></td></tr><tr><td rowspan=5><img src=images/box/leftspacer.gif width=92 height=98></td><td rowspan=4 background=images/box/leftverticalbar.gif><img src=images/box/clear.gif width=4 height=1></td><td background=images/box/topspacer.gif><img src=images/box/clear.gif width=1 height=1></td><td rowspan=4 background=images/box/rightverticalbar.gif><img src=images/box/clear.gif width=6 height=1></td></tr><tr><td background=images/box/title.gif><!-- title --><font size=-1 face=arial><b><a href=<$Logentry.Url$>><$Logentry.Title$></a></b></font><br><img src=images/clear.gif width=10 height=1><font face=arial size=-2></font><br><img src=images/clear.gif width=10 height=1><font face=arial size=-2></font><br><img src=images/box/clear.gif width=6 height=2></td></tr><tr><td background=images/box/bottomspacer.gif><img src=images/box/clear.gif width=1 height=1></td></tr><tr><td><!-- start main content --><font size=-1 face=arial><$Logentry.Body$></font><br><br><font face=arial size=-2><$Messages.Count$> Messages | <$Images.Count$> Images</font><!-- end main content --></td></tr><tr><td valign=top background=images/box/bottomleftcornerbg.gif><img src=images/box/bottomleftcorner.gif width=4 height=6></td><td background=images/box/bottomhorizontalbar.gif><img src=images/box/clear.gif width=1 height=6></td><td valign=top><img src=images/box/bottomrightcorner.gif width=6 height=6></td></tr></table><!-- End Entry -->','Three Column Gold','qlogger.com',1,'threecolumngold.gif',1),
(22,'<html>\r\n   <head>\r\n      <title><$Site.Name$> <$Entry.Title$></title>\r\n   \r\n\r\n<style type=\"text/css\">\r\n<!--\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:25px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 2px;\r\n          background-color: #ccccff;}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 2px;\r\n          background-color: #003366;}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #ffffff; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {background-color: #003366;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #ffffff; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {background-color: #ccccff;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{background-color: #666666;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{background-color: #ffffff;\r\n	      FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{border: solid #ffffff 1px; \r\n          padding: 0px;\r\n          background-color: #ffffff;\r\n	      width: 100%}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n--> \r\n</style>\r\n\r\n\r\n\r\n      <style type=\"text/css\">\r\n\r\n	body\r\n	{background-color:#ffffff;\r\n	margin:0px;\r\n	text-align:center;\r\n	font-family:verdana,sans-serif;\r\n	color:#999999;\r\n	font-size:10px;}\r\n\r\n	a\r\n	{color:#0000ff;\r\n	text-decoration:none}\r\n\r\n	p.title\r\n	{color:#8fa1b3;\r\n	text-align:left;\r\n	font-family:arial narrow, arial, sans-serif;\r\n	font-size:22px; \r\n	margin:0px; \r\n	padding:0px;}\r\n\r\n	p.navheader	\r\n	{font-size:12px; \r\n	font-weight:bold; \r\n	border-bottom: 2px solid #fff; \r\n	color:#fff; \r\n	margin:2px; \r\n	padding:0px;}\r\n\r\n	p.date\r\n	{font-size:14px;\r\n	font-wight:bold;\r\n	border-bottom: 2px solid #fff;\r\n	color:#fff;\r\n	margin:3px;\r\n	padding:0px;}\r\n\r\n	p.signature\r\n	{font-size:10px;\r\n	width:100px;\r\n	text-align:right;\r\n	color:#fff;}\r\n\r\n	\r\n	\r\n\r\n      </style>\r\n\r\n   </head>\r\n\r\n   <body bgcolor=#ffffff>\r\n\r\n<center>\r\n<font face=arial size=+3 color=#000000><$Site.Name$></font>\r\n</center>\r\n<br>\r\n<table cellpadding=0 cellspacing=0 border=0 bgcolor=#000000 width=95%><tr><td>\r\n<table cellpadding=0 cellspacing=1  width=100% border=0>\r\n\r\n<tr>\r\n<td bgcolor=\"#0099cc\">\r\n<font color=#0099cc>.</font>\r\n</td>\r\n</tr>\r\n\r\n<tr>\r\n<td bgcolor=#ffffcc>\r\n\r\n<!-- Start Center Inside Table -->\r\n<table cellpadding=0 cellspacing=0 width=100% border=0 bgcolor=#ffffcc><tr><td>\r\n<table cellpadding=0 cellspacing=3 width=100% border=0>\r\n<tr>\r\n<td>\r\n<!-- Start Content Table -->\r\n<table cellpadding=0 cellspacing=0 width=100% border=0 bgcolor=#000000><tr><td>\r\n<table cellpadding=0 cellspacing=1 width=100% border=0>\r\n<tr>\r\n<td valign=top bgcolor=#ccccff width=200>\r\n<$Navbar.Vertical$>\r\n</td>\r\n<td valign=top bgcolor=#ffffff>\r\n<table cellpadding=5 cellspacing=0 border=0><tr><td>\r\n<$Main.Body$>\r\n</td></tr></table>\r\n</td>\r\n<td valign=top bgcolor=#ccccff width=200>\r\n<$Side.Column$>\r\n</td>\r\n</tr>\r\n</table>\r\n                                                                                                                       \r\n</td>\r\n</tr>\r\n</table>\r\n</td></tr></table>\r\n<!-- End Content Table -->\r\n</td>\r\n</tr>\r\n</table>	\r\n</td></tr></table>\r\n<!-- End Center Inside Table -->\r\n</td>\r\n</tr>\r\n\r\n\r\n</table>	\r\n</td></tr></table>\r\n\r\n   </body>\r\n</html>','<!-- Begin Entry --><table width=100% border=0 cellpadding=0 cellspacing=0><tr><td rowspan=2 valign=top width=92><$Ago.Graphic.1$></td><td width=4 rowspan=2 valign=top background=images/box/upperleftcornerbg.gif><img src=images/box/upperleftcorner.gif width=4 height=24></td><td width=100% background=images/box/tophorizontalbar.gif><!-- this gif must be (widthoftable-92) --><img src=images/box/clear.gif width=100% height=4></td><td width=6 rowspan=2 valign=top background=images/box/rightverticalbar.gif><img src=images/box/upperrightcorner.gif width=6 height=24></td></tr><tr><td background=images/box/date.gif valign=middle><img src=images/box/clear.gif width=1 height=20 align=right><img src=images/box/clear.gif width=1 height=13><font size=-2 face=arial><$Logentry.Datetime.Expanded$> :: <$Log.Name$></font></td></tr><tr><td rowspan=5><img src=images/box/leftspacer.gif width=92 height=98></td><td rowspan=4 background=images/box/leftverticalbar.gif><img src=images/box/clear.gif width=4 height=1></td><td background=images/box/topspacer.gif><img src=images/box/clear.gif width=1 height=1></td><td rowspan=4 background=images/box/rightverticalbar.gif><img src=images/box/clear.gif width=6 height=1></td></tr><tr><td background=images/box/title.gif><!-- title --><font size=-1 face=arial><b><a href=<$Logentry.Url$>><$Logentry.Title$></a></b></font><br><img src=images/clear.gif width=10 height=1><font face=arial size=-2></font><br><img src=images/clear.gif width=10 height=1><font face=arial size=-2></font><br><img src=images/box/clear.gif width=6 height=2></td></tr><tr><td background=images/box/bottomspacer.gif><img src=images/box/clear.gif width=1 height=1></td></tr><tr><td><!-- start main content --><font size=-1 face=arial><$Logentry.Body$></font><br><br><font face=arial size=-2><$Messages.Count$> Messages | <$Images.Count$> Images</font><!-- end main content --></td></tr><tr><td valign=top background=images/box/bottomleftcornerbg.gif><img src=images/box/bottomleftcorner.gif width=4 height=6></td><td background=images/box/bottomhorizontalbar.gif><img src=images/box/clear.gif width=1 height=6></td><td valign=top><img src=images/box/bottomrightcorner.gif width=6 height=6></td></tr></table><!-- End Entry -->','Three Column Blue','qlogger.com',1,'threecolumnblue.gif',1),
(23,'<html>\r\n<head>\r\n	<title><$Site.Name$> <$Entry.Title$></title>\r\n	\r\n<style type=\"text/css\">\r\n<!--\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:15px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 0px;\r\n          background-color: #333333;}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 0px;\r\n          background-color: #333333;}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #ffffff; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #ffffff; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {background-color: #e6e6e6;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{background-color: #e6e6e6;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{background-color: #ffffff;\r\n	      FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{border: solid #ffffff 1px; \r\n          padding: 0px;\r\n          background-color: #ffffff;\r\n	      width: 100%}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n\r\n.navcolumn{border-left: dashed #000000 1px;}\r\n\r\n--> \r\n</style>\r\n\r\n\r\n	\r\n</head>\r\n\r\n<body bgcolor=#6666cc LEFTMARGIN=\'0\' TOPMARGIN=\'0\' MARGINWIDTH=\'0\' MARGINHEIGHT=\'0\'>\r\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=100%>\r\n<tr>\r\n    <td valign=bottom align=left width=154><img src=\"images/template/templatename/asterisk/asterisk-top-blue.gif\" width=\"154\" height=\"82\" alt=\"\" border=\"0\"></td>\r\n    <td colspan=\"2\" valign=bottom><font face=arial size=+3 color=#000000><$Site.Name$></font></td>\r\n</tr>\r\n<tr>\r\n    <td bgcolor=#333333><img src=\"images/template/templatename/asterisk/asterisk-middle.gif\" width=\"154\" height=\"24\" alt=\"\" border=\"0\"></td>\r\n    <td colspan=\"2\" bgcolor=#333333><$Navbar.Horizontal$></td>\r\n</tr>\r\n<tr>\r\n    <td valign=top bgcolor=#ffffff><img src=\"images/template/templatename/asterisk/asterisk-bottom.gif\" width=\"154\" height=\"49\" alt=\"\" border=\"0\"></td>\r\n    <td bgcolor=#ffffff><img src=\"images/clear.gif\" width=\"1\" height=\"1\" alt=\"\" border=\"0\"><font face=arial size=-1 color=#cccccc><strong><$Log.Name$></strong></font></td>\r\n    <td class=navcolumn bgcolor=#e6e6e6 rowspan=\"2\" width=25% valign=top><$Side.Column$></td>\r\n</tr>\r\n<tr>\r\n    <td bgcolor=#ffffff valign=top><img src=\"images/clear.gif\" width=\"1\" height=\"1\" alt=\"\" border=\"0\"></td>\r\n    <td bgcolor=#ffffff><$Main.Body$></td>\r\n</tr>\r\n<tr>\r\n    <td colspan=\"3\" bgcolor=#333333><img src=\"images/clear.gif\" width=\"1\" height=\"10\" alt=\"\" border=\"0\"></td>\r\n</tr>\r\n<tr>\r\n    <td colspan=\"3\"></td>\r\n</tr>\r\n</table>\r\n\r\n\r\n\r\n</body>\r\n</html>','<table border=0 cellpadding=3>\r\n<tr>\r\n<td valign=top>\r\n<a href=<$Logentry.Url$>><img src=\"images/template/templatename/asterisk/asterisk.gif\" alt=\"\" border=\"0\" align=middle></a>\r\n</td>\r\n<td valign=top>\r\n<a href=<$Logentry.Url$>><font face=arial size=+1 color=\"#6666cc\"><strong><$Logentry.Title$></strong></font></a>\r\n<br>\r\n<font face=arial size=-1 color=#000000><strong><$Ago.Text$> :: <$Log.Name$></strong></font>\r\n<br>\r\n<font face=arial size=-1 color=#000000><$Logentry.Body$></font>\r\n<br> \r\n<font face=arial size=-2 color=#000000><$Logentry.Datetime.Expanded$> | <$Messages.Count$> Messages | <$Images.Count$> Images</font>\r\n</td>\r\n</tr>\r\n</table>','Asterisk Blue','qlogger.com',1,'asteriskblue.gif',1),
(24,'<html>\r\n<head>\r\n  <title><$Site.Name$> <$Entry.Title$></title>\r\n\r\n<style>\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:25px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#666666;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%;background-color: #cccccc;}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 2px;\r\n          background-color: #cccccc;\r\n	      width: 100%}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 2px;\r\n          background-color: #cccccc;\r\n	  width: 100%}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #334C66; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{background-color: #999999;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{background-color: #ffffcc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{background-color: #ffffff;\r\n	      FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{padding: 0px;\r\n          background-color: #cccccc;\r\n	      width: 100%}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n		  \r\n</style>\r\n\r\n</head>\r\n<body bgcolor=\"#ffffff\" text=\"#000000\" link=\"#0000ff\" vlink=\"#0000ff\">\r\n<center>\r\n<table cellpadding=0 cellspacing=0 border=0 bgcolor=#000000 width=95%><tr><td>\r\n<table cellpadding=3 cellspacing=2 border=0 width=100%>\r\n\r\n<tr>\r\n<td colspan=3 valign=bottom align=right bgcolor=\"#ffcc00\" background=\"images/template/tiledbgimages/celtic02.jpg\">\r\n<br><br><br><font face=arial size=+3><b><$Site.Name$></b></font>\r\n</td>\r\n</tr>\r\n\r\n<tr>\r\n<td valign=top bgcolor=\"#cccccc\" width=150>\r\n<$Navbar.Vertical$>\r\n</td>\r\n<td valign=top bgcolor=#ffffff>\r\n<$Main.Body$>\r\n</td>\r\n<td valign=top bgcolor=#cccccc width=200 align=center>\r\n<$Side.Column$>\r\n</td>\r\n</tr>\r\n\r\n</table></td></tr></table>\r\n</center>\r\n</body>\r\n</html>','<!-- Begin Entry --><table width=100% border=0 cellpadding=0 cellspacing=0><tr><td rowspan=2 valign=top width=92><$Ago.Graphic.1$></td><td width=4 rowspan=2 valign=top background=images/box/upperleftcornerbg.gif><img src=images/box/upperleftcorner.gif width=4 height=24></td><td width=100% background=images/box/tophorizontalbar.gif><!-- this gif must be (widthoftable-92) --><img src=images/box/clear.gif width=100% height=4></td><td width=6 rowspan=2 valign=top background=images/box/rightverticalbar.gif><img src=images/box/upperrightcorner.gif width=6 height=24></td></tr><tr><td background=images/box/date.gif valign=middle><img src=images/box/clear.gif width=1 height=20 align=right><img src=images/box/clear.gif width=1 height=13><font size=-2 face=arial><$Logentry.Datetime.Expanded$> :: <$Log.Name$></font></td></tr><tr><td rowspan=5><img src=images/box/leftspacer.gif width=92 height=98></td><td rowspan=4 background=images/box/leftverticalbar.gif><img src=images/box/clear.gif width=4 height=1></td><td background=images/box/topspacer.gif><img src=images/box/clear.gif width=1 height=1></td><td rowspan=4 background=images/box/rightverticalbar.gif><img src=images/box/clear.gif width=6 height=1></td></tr><tr><td background=images/box/title.gif><!-- title --><font size=-1 face=arial><b><a href=<$Logentry.Url$>><$Logentry.Title$></a></b></font><br><img src=images/clear.gif width=10 height=1><font face=arial size=-2></font><br><img src=images/clear.gif width=10 height=1><font face=arial size=-2></font><br><img src=images/box/clear.gif width=6 height=2></td></tr><tr><td background=images/box/bottomspacer.gif><img src=images/box/clear.gif width=1 height=1></td></tr><tr><td><!-- start main content --><font size=-1 face=arial><$Logentry.Body$></font><br><br><font face=arial size=-2><$Messages.Count$> Messages | <$Images.Count$> Images</font><!-- end main content --></td></tr><tr><td valign=top background=images/box/bottomleftcornerbg.gif><img src=images/box/bottomleftcorner.gif width=4 height=6></td><td background=images/box/bottomhorizontalbar.gif><img src=images/box/clear.gif width=1 height=6></td><td valign=top><img src=images/box/bottomrightcorner.gif width=6 height=6></td></tr></table><!-- End Entry -->','Three Column Creme Pattern','qlogger.com',1,'threecolumncremepattern.gif',1),
(25,'<html>\r\n<head>\r\n<title><$Site.Name$> <$Entry.Title$></title>\r\n<style>\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:25px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 2px;\r\n          background-color: #ffffcc;\r\n	      width: 100%}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 2px;\r\n          background-color: #ffcc00;\r\n	  width: 100%}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {background-color: #ffcc66;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #666666; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {background-color: #ffffcc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{background-color: #ffcc66;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{background-color: #ffffcc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{background-color: #ffcc00;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{background-color: #ffffff;\r\n	      FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{border: solid #cccccc 1px; \r\n          padding: 0px;\r\n          background-color: #cccccc;\r\n	      width: 100%}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n		  \r\n</style>\r\n\r\n\r\n\r\n\r\n<style type=\"text/css\">\r\n<!--\r\n.main {COLOR: #ffcc00; FONT-FAMILY: verdana, arial, helvetica, sans-serif; FONT-SIZE: 10px; TEXT-DECORATION: none}\r\n\r\n.little {COLOR: #99B2CC; FONT-FAMILY: verdana, arial, helvetica, sans-serif; FONT-SIZE: 9px; TEXT-DECORATION: none}\r\n\r\n.heading {color: #ffcc00; border-bottom: 1px #ffcc66 solid; FONT-FAMILY: verdana, arial, helvetica, sans-serif; font-size: 12px; text-decoration: none; font-weight: bold; background-color: #ffcc00}\r\n\r\n.tablish {border-top: 1px #333333 solid; border-right: 1px #cccccc solid; border-bottom: 1px #cccccc solid; border-left: 1px #cccccc solid; color: #000000; background-color: #ffffcc }\r\n\r\n.headish {border-top: 1px #000000 solid; border-right: 1px #ffcc00 solid; border-bottom: 1px #000000 solid; border-left: 1px #ffcc00 solid; background-color: #ffcc00; color: #333333; FONT-FAMILY: verdana, arial, helvetica, sans-serif; font-size: 24px; text-decoration: none; text-transform: lowercase; font-weight: bold }\r\n\r\n\r\n-->\r\n</style>\r\n</head>\r\n\r\n<body bgcolor=\"#a9a9a9\" leftmargin=0 rightmargin=0 topmargin=0>\r\n<table width=\"100%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#cccccc\">\r\n  <tr> \r\n    <td align=\"left\" class=\"headish\"><p><$Site.Name$> :: <$Log.Name$></p?</td>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n     <table width=\"100%\" cellpadding=\"0\" cellspacing=\"10\">\r\n      <tr valign=\"top\">\r\n       <td width=\"65%\">    		\r\n			\r\n			<$Main.Body$>\r\n       </td>\r\n       <td width=\"35%\" class=\"tablish\" valign=top>\r\n	   		<$Navbar.Vertical$>\r\n			<br>\r\n        	<$Side.Column$>\r\n       </td>\r\n      </tr>\r\n     </table>\r\n    </td>\r\n  </tr>\r\n  <tr> \r\n    <td align=\"right\" class=\"headish\"><p class=\"little\"></p></td>\r\n  </tr>\r\n </table>\r\n</body>\r\n</html>','<table width=\"100%\" class=\"tablish\" cellpadding=\"4\" cellspacing=\"0\"> \r\n         <tr class=\"heading\"> \r\n          <td><a href=<$Logentry.Url$>> <$Logentry.Title$></a></td>\r\n         </tr>\r\n         <tr class=\"main\"> \r\n          <td><p><$Ago.Text$> :: <$Log.Name$></p>\r\n		  <p><$Logentry.Body$></p>\r\n          <p class=\"little\"><$Messages.Count$> Messages | <$Images.Count$> Images | <$Logentry.Datetime.Expanded$> | <a href=<$Logentry.Url$>>More >></a></p>\r\n           </td>\r\n         </tr>\r\n</table>','Yellow Fever','qlogger.com',1,'yellowfever.gif',1),
(26,'<html>\r\n<head>\r\n  <title><$Site.Name$> <$Entry.Title$></title>\r\n\r\n<style>\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:25px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#666666;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%;background-color: #cccccc;}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 2px;\r\n          background-color: #cccccc;\r\n	      width: 100%}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 2px;\r\n          background-color: #cccccc;\r\n	  width: 100%}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #334C66; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{background-color: #999999;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{background-color: #ffffff;\r\n	      FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{padding: 0px;\r\n          background-color: #cccccc;\r\n	      width: 100%}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n		  \r\n</style>\r\n\r\n</head>\r\n<body bgcolor=\"#ffffff\" text=\"#000000\" link=\"#0000ff\" vlink=\"#0000ff\">\r\n<center>\r\n<table cellpadding=0 cellspacing=0 border=0 bgcolor=#000000 width=95%><tr><td>\r\n<table cellpadding=3 cellspacing=2 border=0 width=100%>\r\n\r\n<tr>\r\n<td colspan=3 valign=bottom align=right bgcolor=\"#ffcc00\" background=\"images/template/tiledbgimages/birds01.jpg\">\r\n<br><br><br><font face=arial size=+3 color=#000000><b><$Site.Name$></b></font>\r\n</td>\r\n</tr>\r\n\r\n<tr>\r\n<td valign=top bgcolor=\"#cccccc\" width=150>\r\n<$Navbar.Vertical$>\r\n</td>\r\n<td valign=top bgcolor=#ffffff>\r\n<$Main.Body$>\r\n</td>\r\n<td valign=top bgcolor=#cccccc width=200 align=center>\r\n<$Side.Column$>\r\n</td>\r\n</tr>\r\n\r\n</table></td></tr></table>\r\n</center>\r\n</body>\r\n</html>','<p>\r\n<a href=<$Logentry.Url$>><font face=arial size=+1 color=#000000><$Logentry.Title$></font></a>\r\n<br>\r\n<font face=arial size=-1 color=#000000><strong><$Ago.Text$> :: <$Log.Name$></strong></font>\r\n<br>\r\n<font face=arial size=-1 color=#000000><$Logentry.Body$></font>\r\n<br> \r\n<font face=arial size=-2 color=#000000><$Logentry.Datetime.Expanded$> | <$Messages.Count$> Messages | <$Images.Count$> Images</font>','Soaring','qlogger.com',1,'soaring.gif',1),
(28,'<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n<html>\r\n<head>\r\n<style type=\"text/css\">\r\n<!--\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:25px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 2px;\r\n          background-color: #ffffff;\r\n	      width: 100%}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 2px;\r\n          background-color: #ffffff;\r\n	  width: 100%}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {background-color: #ffffff;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {background-color: #ffffff;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #ffffff; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{background-color: #ffffff;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{background-color: #ffffff;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{background-color: #ffffff;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{background-color: #ffffff;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{background-color: #ffffff;\r\n	      FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{border: solid #ffffff 1px; \r\n          padding: 0px;\r\n          background-color: #ffffff;\r\n	      width: 100%}\r\n.caffeinecell{background-color: #ffffff;}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n--> \r\n</style>\r\n\r\n	<title><$Site.Name$> <$Entry.Title$></title>\r\n</head>\r\n<body bgcolor=#ffffff LEFTMARGIN=\'0\' TOPMARGIN=\'0\' MARGINWIDTH=\'0\' MARGINHEIGHT=\'0\'>\r\n<font face=arial size=+3 color=#000000><$Site.Name$></font>\r\n<br>\r\n<table cellpadding=0 cellspacing=0 border=0 width=100%>\r\n<td valign=top width=150>\r\n<$Navbar.Vertical$>\r\n</td>\r\n\r\n<td valign=top nowrap>  </td>\r\n\r\n<td valign=top>\r\n<$Main.Body$>\r\n</td>\r\n\r\n<td valign=top nowrap>  </td>\r\n\r\n<td valign=top width=200>\r\n<$Side.Column$>\r\n</td>\r\n</tr>\r\n</table>\r\n</body>\r\n</html>','<p>\r\n<a href=<$Logentry.Url$>><font face=arial size=+1 color=#000000><$Logentry.Title$></font></a>\r\n<br>\r\n<font face=arial size=-1 color=#000000><strong><$Ago.Text$> :: <$Log.Name$></strong></font>\r\n<br>\r\n<font face=arial size=-1 color=#000000><$Logentry.Body$></font>\r\n<br> \r\n<font face=arial size=-2 color=#000000><$Logentry.Datetime.Expanded$> | <$Messages.Count$> Messages | <$Images.Count$> Images</font>','Whiteout','qlogger.com',1,'whiteout.gif',1),
(29,'<html>\r\n<head>\r\n  <title><$Site.Name$> <$Entry.Title$></title>\r\n\r\n<style>\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:25px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#666666;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%;background-color: #cccccc;}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 2px;\r\n          background-color: #cccccc;\r\n	      width: 100%}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 2px;\r\n          background-color: #ff3300;\r\n	  width: 100%}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {background-color: #ff3300;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #334C66; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{background-color: #999999;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{background-color: #ffffcc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{background-color: #ffffff;\r\n	      FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{padding: 0px;\r\n          background-color: #cccccc;\r\n	      width: 100%}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n		  \r\n</style>\r\n\r\n</head>\r\n<body bgcolor=\"#ffffff\" text=\"#000000\" link=\"#0000ff\" vlink=\"#0000ff\">\r\n<center>\r\n<table cellpadding=0 cellspacing=0 border=0 bgcolor=#000000 width=95%><tr><td>\r\n<table cellpadding=3 cellspacing=2 border=0 width=100%>\r\n\r\n<tr>\r\n<td colspan=3 valign=bottom align=right bgcolor=\"#ff3300\">\r\n<br><br><br><font face=arial size=+3><$Site.Name$></font>\r\n</td>\r\n</tr>\r\n\r\n<tr>\r\n<td valign=top bgcolor=\"#cccccc\" width=150>\r\n<$Navbar.Vertical$>\r\n</td>\r\n<td valign=top bgcolor=#ffffff>\r\n<$Main.Body$>\r\n</td>\r\n<td valign=top bgcolor=#cccccc width=200 align=center>\r\n<$Side.Column$>\r\n</td>\r\n</tr>\r\n\r\n</table></td></tr></table>\r\n</center>\r\n</body>\r\n</html>','<p>\r\n<a href=<$Logentry.Url$>><font face=arial size=+1><$Logentry.Title$></font></a>\r\n<br>\r\n<font face=arial size=-1><strong><$Ago.Text$> :: <$Log.Name$></strong></font>\r\n<br>\r\n<font face=arial size=-1><$Logentry.Body$></font>\r\n<br> \r\n<font face=arial size=-2><$Logentry.Datetime.Expanded$> | <$Messages.Count$> Messages | <$Images.Count$> Images</font>','Three Column Red','qlogger.com',1,'threecolumnred.gif',1),
(30,'<html>\r\n<head>\r\n	<title><$Site.Name$> <$Entry.Title$></title>\r\n	\r\n<style type=\"text/css\">\r\n<!--\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:15px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 0px;\r\n          background-color: #333333;}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 0px;\r\n          background-color: #333333;}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #ffffff; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #ffffff; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {background-color: #e6e6e6;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{background-color: #e6e6e6;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{background-color: #ffffff;\r\n	      FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{border: solid #ffffff 1px; \r\n          padding: 0px;\r\n          background-color: #ffffff;\r\n	      width: 100%}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n\r\n.navcolumn{border-left: dashed #000000 1px;}\r\n\r\n--> \r\n</style>\r\n\r\n\r\n	\r\n</head>\r\n\r\n<body bgcolor=#ff99cc LEFTMARGIN=\'0\' TOPMARGIN=\'0\' MARGINWIDTH=\'0\' MARGINHEIGHT=\'0\'>\r\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=100%>\r\n<tr>\r\n    <td valign=bottom align=left width=154><img src=\"images/template/templatename/asterisk/asterisk-top-pink.gif\" width=\"154\" height=\"82\" alt=\"\" border=\"0\"></td>\r\n    <td colspan=\"2\" valign=bottom><font face=arial size=+3 color=#000000><$Site.Name$></font></td>\r\n</tr>\r\n<tr>\r\n    <td bgcolor=#333333><img src=\"images/template/templatename/asterisk/asterisk-middle.gif\" width=\"154\" height=\"24\" alt=\"\" border=\"0\"></td>\r\n    <td colspan=\"2\" bgcolor=#333333><$Navbar.Horizontal$></td>\r\n</tr>\r\n<tr>\r\n    <td valign=top bgcolor=#ffffff><img src=\"images/template/templatename/asterisk/asterisk-bottom.gif\" width=\"154\" height=\"49\" alt=\"\" border=\"0\"></td>\r\n    <td bgcolor=#ffffff><img src=\"images/clear.gif\" width=\"1\" height=\"1\" alt=\"\" border=\"0\"><font face=arial size=-1 color=#cccccc><strong><$Log.Name$></strong></font></td>\r\n    <td class=navcolumn bgcolor=#e6e6e6 rowspan=\"2\" width=25% valign=top><$Side.Column$></td>\r\n</tr>\r\n<tr>\r\n    <td bgcolor=#ffffff valign=top><img src=\"images/clear.gif\" width=\"1\" height=\"1\" alt=\"\" border=\"0\"></td>\r\n    <td bgcolor=#ffffff><$Main.Body$></td>\r\n</tr>\r\n<tr>\r\n    <td colspan=\"3\" bgcolor=#333333><img src=\"images/clear.gif\" width=\"1\" height=\"10\" alt=\"\" border=\"0\"></td>\r\n</tr>\r\n<tr>\r\n    <td colspan=\"3\"></td>\r\n</tr>\r\n</table>\r\n\r\n\r\n\r\n</body>\r\n</html>','<table border=0 cellpadding=3>\r\n<tr>\r\n<td valign=top>\r\n<a href=<$Logentry.Url$>><img src=\"images/template/templatename/asterisk/asterisk.gif\" alt=\"\" border=\"0\" align=middle></a>\r\n</td>\r\n<td valign=top>\r\n<a href=<$Logentry.Url$>><font face=arial size=+1 color=\"#cc0099\"><strong><$Logentry.Title$></strong></font></a>\r\n<br>\r\n<font face=arial size=-1 color=#000000><strong><$Ago.Text$> :: <$Log.Name$></strong></font>\r\n<br>\r\n<font face=arial size=-1 color=#000000><$Logentry.Body$></font>\r\n<br> \r\n<font face=arial size=-2 color=#000000><$Logentry.Datetime.Expanded$> | <$Messages.Count$> Messages | <$Images.Count$> Images</font>\r\n</td>\r\n</tr>\r\n</table>','Asterisk Pink','qlogger.com',1,'asteriskpink.gif',1),
(31,'<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n<html>\r\n<head>\r\n	<title><$Site.Name$> <$Entry.Title$></title>\r\n	<style type=\"text/css\">\r\n<!--\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:25px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 2px;\r\n          background-color: #cccccc;}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 2px;\r\n          background-color: #990066;}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 12px; color: #ffffff; text-transform: uppercase;\r\n		letter-spacing: 0.2em;\r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {background-color: #990066;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #ffffff; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{background-color: #666666;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{background-color: #ffffff;\r\n	      FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{border: solid #ffffff 1px; \r\n          padding: 0px;\r\n          background-color: #ffffff;\r\n	      width: 100%}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n--> \r\n</style>\r\n\r\n\r\n	<style type=\"text/css\">\r\n	<!--\r\n	body {\r\n		font-size : 11px;\r\n		font-family: verdana, arial, helvetica, sans-serif;\r\n		font-weight: normal;\r\n		font-style: normal;\r\n		text-decoration: none;\r\n		font-weight: none;\r\n		scrollbar-face-color: #990066;\r\n		scrollbar-shadow-color: #FFFFFF;\r\n		scrollbar-highlight-color: #FFFFFF;\r\n		scrollbar-3dlight-color: #990066;\r\n		scrollbar-darkshadow-color: #990066;\r\n		scrollbar-track-color: #990066;\r\n		scrollbar-arrow-color: #FFFFFF;\r\n	}\r\n	.top {\r\n		background-color: #990066;\r\n		color: #FFFFFF;\r\n		font-size : 14px;\r\n		font-family: verdana, arial, helvetica, sans-serif;\r\n		font-style: normal;\r\n		text-decoration: none;\r\n		font-weight: bold;\r\n		text-transform: uppercase;\r\n		letter-spacing: 0.2em;\r\n		padding: 5px;\r\n		margin: 0px;\r\n		width: 100%;\r\n		height: 25px;\r\n		text-align: left;\r\n		border-color: #990066;\r\n		border-style: solid;\r\n		border-top-width: 1px;\r\n		border-left-width: 0px;\r\n		border-right-width: 0px;\r\n		border-bottom-width: 1px;\r\n		position: absolute;\r\n\r\n	top: 100px;\r\n\r\n		left: 0px;\r\n	}\r\n	.log {\r\n		overflow: auto;\r\n		background-color:#FFFFF;\r\n		padding: 5px;\r\n		margin: 0px;\r\n		width: 500px;\r\n\r\n	        height: 391px;\r\n\r\n		border-color: #990066;\r\n		border-style: solid;\r\n		border-top-width: 1px;\r\n		border-left-width: 1px;\r\n		border-right-width: 1px;\r\n		border-bottom-width: 1px;\r\n		position: absolute;\r\n\r\n	top: 150px;\r\n\r\n		left: 25px;\r\n	}\r\n	h3 {\r\n		color: #808080;\r\n		font-size: 12px;\r\n		font-weight: bold;\r\n		text-decoration: underline;\r\n	}\r\n	.text {\r\n		color: #000000;\r\n		width: 90%;\r\n		text-align: left;\r\n	}\r\n	.side {\r\n		background-color:#FFFFFF;\r\n		color: #000000;\r\n		padding: 5px;\r\n		margin: 0px;\r\n		width: 200px;\r\n\r\n	height: 391px;\r\n\r\n		text-align: left;\r\n		border-color: #990066;\r\n		border-style: solid;\r\n		border-top-width: 1px;\r\n		border-left-width: 1px;\r\n		border-right-width: 1px;\r\n		border-bottom-width: 1px;\r\n		position: absolute;\r\n\r\n	top: 150px;\r\n\r\n		left: 550px;\r\n	}\r\n	.bottom {\r\n		background-color: #990066;\r\n		color: #FFFFFF;\r\n		font-size : 14px;\r\n		font-family: verdana, arial, helvetica, sans-serif;\r\n		font-style: normal;\r\n		text-decoration: none;\r\n		font-weight: bold;\r\n		font-transform: lowercase;\r\n		letter-spacing: 0.2em;\r\n		padding: 5px;\r\n		margin: 0px;\r\n		width: 100%;\r\n		height: 25px;\r\n		text-align: right;\r\n		border-color: #990066;\r\n		border-style: solid;\r\n		border-top-width: 1px;\r\n		border-left-width: 0px;\r\n		border-right-width: 0px;\r\n		border-bottom-width: 1px;\r\n		left: 0px;\r\n\r\n\r\n	}\r\n	a:link, a:active, a:visited {\r\n		color: #808080;\r\n		font-weight: none;\r\n		text-decoration: none;\r\n	}\r\n	a:hover {\r\n		text-decoration: underline;\r\n	}\r\n	a.blink:link, a.blink:active, a.blink:visited {\r\n		color: #808080;\r\n		font-weight: bold;\r\n		text-decoration: underline;\r\n	}\r\n	a.blink:hover {\r\n		text-decoration: none;\r\n	}\r\n	-->\r\n	</style>\r\n</head>\r\n\r\n<body leftmargin=\"0\" rightmargin=\"0\" topmargin=\"0\">\r\n\r\n<div class=\"top\"><$Site.Name$></div>\r\n\r\n<div class=\"log\"><div class=\"text\">\r\n<$Main.Body$>\r\n</div></div>\r\n\r\n<div class=\"side\">\r\n	<$Navbar.Vertical$>\r\n	<br>\r\n	<$Side.Column$>\r\n</div>\r\n\r\n</body>\r\n</html>','<p>\r\n<a href=<$Logentry.Url$>><font face=arial size=+1 color=#990066><$Logentry.Title$></font></a>\r\n<br>\r\n<font face=arial size=-1 color=#000000><strong><$Ago.Text$> :: <$Log.Name$></strong></font>\r\n<br>\r\n<font face=arial size=-1 color=#000000><$Logentry.Body$></font>\r\n<br> \r\n<font face=arial size=-2 color=#000000><$Logentry.Datetime.Expanded$> | <$Messages.Count$> Messages | <$Images.Count$> Images</font>','Pink Elephant','dholden84',1,'pinkelephant.gif',1),
(32,'<html>\r\n<head>\r\n  <title><$Site.Name$> <$Entry.Title$></title>\r\n\r\n<style>\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:25px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#666666;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%;background-color: #cccccc;}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 2px;\r\n          background-color: #cccccc;\r\n	      width: 100%}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 2px;\r\n          background-color: #006600;\r\n	  width: 100%}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #ffffff; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {background-color: #006600;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #334C66; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{background-color: #999999;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{background-color: #ffffcc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{background-color: #ffffff;\r\n	      FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{padding: 0px;\r\n          background-color: #cccccc;\r\n	      width: 100%}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n		  \r\n</style>\r\n\r\n</head>\r\n<body bgcolor=\"#ffffff\" text=\"#000000\" link=\"#0000ff\" vlink=\"#0000ff\">\r\n<center>\r\n<table cellpadding=0 cellspacing=0 border=0 bgcolor=#000000 width=95%><tr><td>\r\n<table cellpadding=3 cellspacing=2 border=0 width=100%>\r\n\r\n<tr>\r\n<td colspan=3 valign=bottom align=right bgcolor=\"#006600\">\r\n<br><br><br><font face=arial color=#ffffff size=+3><$Site.Name$></font>\r\n</td>\r\n</tr>\r\n\r\n<tr>\r\n<td valign=top bgcolor=\"#cccccc\" width=150>\r\n<$Navbar.Vertical$>\r\n</td>\r\n<td valign=top bgcolor=#ffffff>\r\n<$Main.Body$>\r\n</td>\r\n<td valign=top bgcolor=#cccccc width=200 align=center>\r\n<$Side.Column$>\r\n</td>\r\n</tr>\r\n\r\n</table></td></tr></table>\r\n</center>\r\n</body>\r\n</html>','<p>\r\n<a href=<$Logentry.Url$>><font face=arial size=+1><$Logentry.Title$></font></a>\r\n<br>\r\n<font face=arial size=-1><strong><$Ago.Text$> :: <$Log.Name$></strong></font>\r\n<br>\r\n<font face=arial size=-1><$Logentry.Body$></font>\r\n<br> \r\n<font face=arial size=-2><$Logentry.Datetime.Expanded$> | <$Messages.Count$> Messages | <$Images.Count$> Images</font>','Three Column Green','qlogger.com',1,'threecolumngreen.gif',1),
(33,'<html><head><title><$Site.Name$> <$Entry.Title$></title>\r\n\r\n<style type=\"text/css\">\r\n<!--\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:25px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#6666666;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{border: dashed #999999 1px;\r\n           padding: 2px;\r\n          background-color: #cccccc;}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{border: dashed #999999 1px; padding: 2px;\r\n          background-color: #333333;}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #ffffff; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {border: dashed #999999 1px; width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {background-color: #333333;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #ffffff; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{background-color: #666666;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{background-color: #ffffff;\r\n	      FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{border: solid #ffffff 1px; \r\n          padding: 0px;\r\n          background-color: #ffffff;\r\n	      width: 100%}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n--> \r\n</style>\r\n\r\n\r\n</head>\r\n<body bgcolor=#ffffff link=\'#0000ff\' vlink=\'#000000\' text=\'#000000\' LEFTMARGIN=\'0\' TOPMARGIN=\'0\' MARGINWIDTH=\'0\' MARGINHEIGHT=\'0\'>\r\n<table cellpadding=0 cellspacing=0 width=100% border=0>\r\n\r\n<tr><td colspan=3 valign=top><font face=arial size=+3><$Site.Name$></font><br><$Navbar.Horizontal$></td></tr>\r\n\r\n<tr><td valign=top><br><$Main.Body$></td><td valign=top nowrap>   </td><td valign=top width=200><br><font face=arial size=+2><$Log.Name$></font><br><$Side.Column$></td></tr>\r\n\r\n</table>\r\n</body></html>','<!-- Begin Entry --><table width=100% border=0 cellpadding=0 cellspacing=0><tr><td rowspan=2 valign=top width=92><$Ago.Graphic.1$></td><td width=4 rowspan=2 valign=top background=images/box/upperleftcornerbg.gif><img src=images/box/upperleftcorner.gif width=4 height=24></td><td width=100% background=images/box/tophorizontalbar.gif><!-- this gif must be (widthoftable-92) --><img src=images/box/clear.gif width=100% height=4></td><td width=6 rowspan=2 valign=top background=images/box/rightverticalbar.gif><img src=images/box/upperrightcorner.gif width=6 height=24></td></tr><tr><td background=images/box/date.gif valign=middle><img src=images/box/clear.gif width=1 height=20 align=right><img src=images/box/clear.gif width=1 height=13><font size=-2 face=arial><$Logentry.Datetime.Expanded$> :: <$Log.Name$></font></td></tr><tr><td rowspan=5><img src=images/box/leftspacer.gif width=92 height=98></td><td rowspan=4 background=images/box/leftverticalbar.gif><img src=images/box/clear.gif width=4 height=1></td><td background=images/box/topspacer.gif><img src=images/box/clear.gif width=1 height=1></td><td rowspan=4 background=images/box/rightverticalbar.gif><img src=images/box/clear.gif width=6 height=1></td></tr><tr><td background=images/box/title.gif><!-- title --><font size=-1 face=arial><b><a href=<$Logentry.Url$>><$Logentry.Title$></a></b></font><br><img src=images/clear.gif width=10 height=1><font face=arial size=-2></font><br><img src=images/clear.gif width=10 height=1><font face=arial size=-2></font><br><img src=images/box/clear.gif width=6 height=2></td></tr><tr><td background=images/box/bottomspacer.gif><img src=images/box/clear.gif width=1 height=1></td></tr><tr><td><!-- start main content --><font size=-1 face=arial><$Logentry.Body$></font><br><br><font face=arial size=-2><$Messages.Count$> Messages | <$Images.Count$> Images</font><!-- end main content --></td></tr><tr><td valign=top background=images/box/bottomleftcornerbg.gif><img src=images/box/bottomleftcorner.gif width=4 height=6></td><td background=images/box/bottomhorizontalbar.gif><img src=images/box/clear.gif width=1 height=6></td><td valign=top><img src=images/box/bottomrightcorner.gif width=6 height=6></td></tr></table><!-- End Entry -->','Greyhound Horizontal Nav','qlogger.com',1,'greyhoundhorizontalnav.gif',1),
(34,'<html>\r\n   <head>\r\n      <title><$Site.Name$> <$Entry.Title$></title>\r\n   \r\n\r\n<style type=\"text/css\">\r\n<!--\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:25px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 2px;\r\n          background-color: #cccccc;}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 2px;\r\n          background-color: #333333;}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #ffffff; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {background-color: #333333;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #ffffff; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{background-color: #666666;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{background-color: #ffffff;\r\n	      FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{border: solid #ffffff 1px; \r\n          padding: 0px;\r\n          background-color: #ffffff;\r\n	      width: 100%}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n--> \r\n</style>\r\n\r\n\r\n\r\n      <style type=\"text/css\">\r\n\r\n	body\r\n	{background-color:#000000;\r\n	margin:0px;\r\n	text-align:center;\r\n	font-family:verdana,sans-serif;\r\n	color:#999999;\r\n	font-size:10px;}\r\n\r\n	a\r\n	{color:#0000ff;\r\n	text-decoration:none}\r\n\r\n	p.title\r\n	{color:#8fa1b3;\r\n	text-align:left;\r\n	font-family:arial narrow, arial, sans-serif;\r\n	font-size:22px; \r\n	margin:0px; \r\n	padding:0px;}\r\n\r\n	p.navheader	\r\n	{font-size:12px; \r\n	font-weight:bold; \r\n	border-bottom: 2px solid #fff; \r\n	color:#fff; \r\n	margin:2px; \r\n	padding:0px;}\r\n\r\n	p.date\r\n	{font-size:14px;\r\n	font-wight:bold;\r\n	border-bottom: 2px solid #fff;\r\n	color:#fff;\r\n	margin:3px;\r\n	padding:0px;}\r\n\r\n	p.signature\r\n	{font-size:10px;\r\n	width:100px;\r\n	text-align:right;\r\n	color:#fff;}\r\n\r\n	\r\n	\r\n\r\n      </style>\r\n\r\n   </head>\r\n\r\n   <body background=\"images/template/tiledbgimages/circles02.jpg\">\r\n\r\n<center>\r\n<font face=arial size=+3 color=#000000><$Site.Name$></font>\r\n</center>\r\n<br>\r\n<table cellpadding=0 cellspacing=0 border=0 bgcolor=#000000 width=95%><tr><td>\r\n<table cellpadding=0 cellspacing=1  width=100% border=0>\r\n\r\n<tr>\r\n<td bgcolor=\"#ffcc00\">\r\n<font color=#ffcc00>.</font>\r\n</td>\r\n</tr>\r\n\r\n<tr>\r\n<td bgcolor=#ffffcc>\r\n\r\n<!-- Start Center Inside Table -->\r\n<table cellpadding=0 cellspacing=0 width=100% border=0 bgcolor=#ffffcc><tr><td>\r\n<table cellpadding=0 cellspacing=3 width=100% border=0>\r\n<tr>\r\n<td>\r\n<!-- Start Content Table -->\r\n<table cellpadding=0 cellspacing=0 width=100% border=0 bgcolor=#000000><tr><td>\r\n<table cellpadding=0 cellspacing=1 width=100% border=0>\r\n<tr>\r\n<td valign=top bgcolor=#cccccc width=200>\r\n<$Navbar.Vertical$>\r\n<$Side.Column$>\r\n</td>\r\n<td valign=top bgcolor=#ffffff>\r\n<table cellpadding=5 cellspacing=0 border=0><tr><td>\r\n<$Main.Body$>\r\n</td></tr></table>                                             \r\n</td>\r\n</tr>\r\n</table>\r\n</td></tr></table>\r\n<!-- End Content Table -->\r\n</td>\r\n</tr>\r\n</table>	\r\n</td></tr></table>\r\n<!-- End Center Inside Table -->\r\n</td>\r\n</tr>\r\n\r\n\r\n</table>	\r\n</td></tr></table>\r\n\r\n   </body>\r\n</html>','<!-- Begin Entry --><table width=100% border=0 cellpadding=0 cellspacing=0><tr><td rowspan=2 valign=top width=92><$Ago.Graphic.1$></td><td width=4 rowspan=2 valign=top background=images/box/upperleftcornerbg.gif><img src=images/box/upperleftcorner.gif width=4 height=24></td><td width=100% background=images/box/tophorizontalbar.gif><!-- this gif must be (widthoftable-92) --><img src=images/box/clear.gif width=100% height=4></td><td width=6 rowspan=2 valign=top background=images/box/rightverticalbar.gif><img src=images/box/upperrightcorner.gif width=6 height=24></td></tr><tr><td background=images/box/date.gif valign=middle><img src=images/box/clear.gif width=1 height=20 align=right><img src=images/box/clear.gif width=1 height=13><font size=-2 face=arial><$Logentry.Datetime.Expanded$> :: <$Log.Name$></font></td></tr><tr><td rowspan=5><img src=images/box/leftspacer.gif width=92 height=98></td><td rowspan=4 background=images/box/leftverticalbar.gif><img src=images/box/clear.gif width=4 height=1></td><td background=images/box/topspacer.gif><img src=images/box/clear.gif width=1 height=1></td><td rowspan=4 background=images/box/rightverticalbar.gif><img src=images/box/clear.gif width=6 height=1></td></tr><tr><td background=images/box/title.gif><!-- title --><font size=-1 face=arial><b><a href=<$Logentry.Url$>><$Logentry.Title$></a></b></font><br><img src=images/clear.gif width=10 height=1><font face=arial size=-2></font><br><img src=images/clear.gif width=10 height=1><font face=arial size=-2></font><br><img src=images/box/clear.gif width=6 height=2></td></tr><tr><td background=images/box/bottomspacer.gif><img src=images/box/clear.gif width=1 height=1></td></tr><tr><td><!-- start main content --><font size=-1 face=arial><$Logentry.Body$></font><br><br><font face=arial size=-2><$Messages.Count$> Messages | <$Images.Count$> Images</font><!-- end main content --></td></tr><tr><td valign=top background=images/box/bottomleftcornerbg.gif><img src=images/box/bottomleftcorner.gif width=4 height=6></td><td background=images/box/bottomhorizontalbar.gif><img src=images/box/clear.gif width=1 height=6></td><td valign=top><img src=images/box/bottomrightcorner.gif width=6 height=6></td></tr></table><!-- End Entry -->','Crop Circle Background','qlogger.com',1,'cropcirclebackground.gif',1),
(35,'<html>\r\n<head>\r\n	<title><$Site.Name$> <$Entry.Title$></title>\r\n	\r\n<style type=\"text/css\">\r\n<!--\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:15px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 0px;\r\n          background-color: #333333;}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 0px;\r\n          background-color: #333333;}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #ffffff; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #ffffff; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {background-color: #e6e6e6;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{background-color: #e6e6e6;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{background-color: #ffffff;\r\n	      FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{border: solid #ffffff 1px; \r\n          padding: 0px;\r\n          background-color: #ffffff;\r\n	      width: 100%}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n\r\n.navcolumn{border-left: dashed #000000 1px;}\r\n\r\n--> \r\n</style>\r\n\r\n\r\n	\r\n</head>\r\n\r\n<body bgcolor=#ff9900 LEFTMARGIN=\'0\' TOPMARGIN=\'0\' MARGINWIDTH=\'0\' MARGINHEIGHT=\'0\'>\r\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=100%>\r\n<tr>\r\n    <td valign=bottom align=left width=154><img src=\"images/template/templatename/asterisk/asterisk-top-orange.gif\" width=\"154\" height=\"82\" alt=\"\" border=\"0\"></td>\r\n    <td colspan=\"2\" valign=bottom><font face=arial size=+3 color=#000000><$Site.Name$></font></td>\r\n</tr>\r\n<tr>\r\n    <td bgcolor=#333333><img src=\"images/template/templatename/asterisk/asterisk-middle.gif\" width=\"154\" height=\"24\" alt=\"\" border=\"0\"></td>\r\n    <td colspan=\"2\" bgcolor=#333333><$Navbar.Horizontal$></td>\r\n</tr>\r\n<tr>\r\n    <td valign=top bgcolor=#ffffff><img src=\"images/template/templatename/asterisk/asterisk-bottom.gif\" width=\"154\" height=\"49\" alt=\"\" border=\"0\"></td>\r\n    <td bgcolor=#ffffff><img src=\"images/clear.gif\" width=\"1\" height=\"1\" alt=\"\" border=\"0\"><font face=arial size=-1 color=#cccccc><strong><$Log.Name$></strong></font></td>\r\n    <td class=navcolumn bgcolor=#e6e6e6 rowspan=\"2\" width=25% valign=top><$Side.Column$></td>\r\n</tr>\r\n<tr>\r\n    <td bgcolor=#ffffff valign=top><img src=\"images/clear.gif\" width=\"1\" height=\"1\" alt=\"\" border=\"0\"></td>\r\n    <td bgcolor=#ffffff><$Main.Body$></td>\r\n</tr>\r\n<tr>\r\n    <td colspan=\"3\" bgcolor=#333333><img src=\"images/clear.gif\" width=\"1\" height=\"10\" alt=\"\" border=\"0\"></td>\r\n</tr>\r\n<tr>\r\n    <td colspan=\"3\"></td>\r\n</tr>\r\n</table>\r\n\r\n\r\n\r\n</body>\r\n</html>','<table border=0 cellpadding=3>\r\n<tr>\r\n<td valign=top>\r\n<a href=<$Logentry.Url$>><img src=\"images/template/templatename/asterisk/asterisk.gif\" alt=\"\" border=\"0\" align=middle></a>\r\n</td>\r\n<td valign=top>\r\n<a href=<$Logentry.Url$>><font face=arial size=+1 color=\"#ff9900\"><strong><$Logentry.Title$></strong></font></a>\r\n<br>\r\n<font face=arial size=-1 color=#000000><strong><$Ago.Text$> :: <$Log.Name$></strong></font>\r\n<br>\r\n<font face=arial size=-1 color=#000000><$Logentry.Body$></font>\r\n<br> \r\n<font face=arial size=-2 color=#000000><$Logentry.Datetime.Expanded$> | <$Messages.Count$> Messages | <$Images.Count$> Images</font>\r\n</td>\r\n</tr>\r\n</table>','Asterisk Orange','qlogger.com',1,'asteriskorange.gif',1),
(36,'<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n<html>\r\n<head>\r\n<style type=\"text/css\">\r\n<!--\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:25px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 2px;\r\n	      width: 100%}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 2px;\r\n	  width: 100%}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{padding: 0px;\r\n	      width: 100%}\r\n.caffeinecell{}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n\r\nbody { background: url(\"images/template/tiledbgimages/paper01.jpg\"); background-repeat: repeat; background-color: #ffffff; }\r\n\r\n\r\n--> \r\n</style>\r\n\r\n	<title><$Site.Name$> <$Entry.Title$></title>\r\n</head>\r\n<body bgcolor=#ffffff LEFTMARGIN=\'0\' TOPMARGIN=\'0\' MARGINWIDTH=\'0\' MARGINHEIGHT=\'0\'>\r\n<font face=arial size=+3 color=#000000><$Site.Name$></font>\r\n<br>\r\n<table cellpadding=0 cellspacing=0 border=0 width=750>\r\n<td valign=top width=150>\r\n<$Navbar.Vertical$>\r\n</td>\r\n\r\n<td valign=top nowrap>  </td>\r\n\r\n<td valign=top>\r\n<$Main.Body$>\r\n</td>\r\n\r\n<td valign=top nowrap>  </td>\r\n\r\n<td valign=top width=200>\r\n<$Side.Column$>\r\n</td>\r\n</tr>\r\n</table>\r\n</body>\r\n</html>','<p>\r\n<a href=<$Logentry.Url$>><font face=arial size=+1 color=#000000><$Logentry.Title$></font></a>\r\n<br>\r\n<font face=arial size=-1 color=#000000><strong><$Ago.Text$> :: <$Log.Name$></strong></font>\r\n<br>\r\n<font face=arial size=-1 color=#000000><$Logentry.Body$></font>\r\n<br> \r\n<font face=arial size=-2 color=#000000><$Logentry.Datetime.Expanded$> | <$Messages.Count$> Messages | <$Images.Count$> Images</font>','Tin Foil','qlogger.com',1,'tinfoil.gif',1),
(37,'<html>\r\n<head>\r\n	<title><$Site.Name$> <$Entry.Title$></title>\r\n	\r\n<style type=\"text/css\">\r\n<!--\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:15px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 0px;\r\n          background-color: #ffffcc;}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 0px;\r\n          background-color: #000000;}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #ffffff; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {background-color: #e6e6e6;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{background-color: #e6e6e6;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{background-color: #ffffff;\r\n	      FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{border: solid #ffffff 1px; \r\n          padding: 0px;\r\n          background-color: #ffffff;\r\n	      width: 100%}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n\r\n--> \r\n</style>\r\n\r\n\r\n	\r\n</head>\r\n\r\n<body bgcolor=#000000 LEFTMARGIN=\'0\' TOPMARGIN=\'0\' MARGINWIDTH=\'0\' MARGINHEIGHT=\'0\'>\r\n<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=100%>\r\n<tr>\r\n    <td valign=top bgcolor=#cccccc width=25%>\r\n		<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=100%>\r\n			<tr>\r\n			    <td bgcolor=#000000 align=center background=\"images/template/templatename/dot/dot.gif\"><img src=\"images/clear.gif\" width=8 height=150 border=0></td>\r\n			</tr>\r\n			<tr>\r\n			    <td bgcolor=#000000><img src=\"images/clear.gif\" width=8 height=8 border=0></td>\r\n			</tr>\r\n			<tr>\r\n			    <td bgcolor=#cccccc><$Side.Column$></td>\r\n			</tr>\r\n\r\n		</table>\r\n	</td>\r\n	<td bgcolor=#000000 width=8><img src=\"images/clear.gif\" width=8 height=8 border=0></td>\r\n    <td valign=top bgcolor=#ffffff>\r\n		<table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=100%>\r\n			<tr>\r\n			    <td bgcolor=#333333><img src=\"images/clear.gif\" width=8 height=50 border=0 align=left><$Site.Name$></td>\r\n			</tr>\r\n			<tr>\r\n			    <td bgcolor=#000000><img src=\"images/clear.gif\" width=8 height=8 border=0></td>\r\n			</tr>\r\n			<tr>\r\n			    <td bgcolor=#ffffcc><$Navbar.Horizontal$></td>\r\n			</tr>\r\n			<tr>\r\n			    <td bgcolor=#000000><img src=\"images/clear.gif\" width=8 height=8 border=0></td>\r\n			</tr>\r\n			<tr>\r\n			    <td bgcolor=#ffffff valign=top><$Main.Body$></td>\r\n			</tr>\r\n		</table>\r\n	</td>\r\n</tr>\r\n</table>\r\n\r\n\r\n</body>\r\n</html>','<table border=0 cellpadding=3>\r\n<tr>\r\n<td valign=top>\r\n<a href=<$Logentry.Url$>><img src=\"images/template/templatename/dot/dot-entry.gif\" alt=\"\" border=\"0\" align=middle></a>\r\n</td>\r\n<td valign=top>\r\n<a href=<$Logentry.Url$>><font face=arial size=+1 color=\"#000000\"><strong><$Logentry.Title$></strong></font></a>\r\n<br>\r\n<font face=arial size=-1 color=#000000><strong><$Ago.Text$> :: <$Log.Name$></strong></font>\r\n<br>\r\n<font face=arial size=-1 color=#000000><$Logentry.Body$></font>\r\n<br> \r\n<font face=arial size=-2 color=#000000><$Logentry.Datetime.Expanded$> | <$Messages.Count$> Messages | <$Images.Count$> Images</font>\r\n</td>\r\n</tr>\r\n</table>','Mega Dots','qlogger.com',1,'megadots.gif',1),
(38,'<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n<html>\r\n<head>\r\n	<title><$Site.Name$> <$Entry.Title$></title>\r\n	<style type=\"text/css\">\r\n<!--\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:25px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 2px;\r\n          background-color: #cccccc;}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 2px;\r\n          background-color: #333333;}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 12px; color: #ffffff; text-transform: uppercase;\r\n		letter-spacing: 0.2em;\r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {background-color: #333333;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #ffffff; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{background-color: #666666;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{background-color: #ffffff;\r\n	      FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{border: solid #ffffff 1px; \r\n          padding: 0px;\r\n          background-color: #ffffff;\r\n	      width: 100%}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n--> \r\n</style>\r\n\r\n\r\n	<style type=\"text/css\">\r\n	<!--\r\n	body {\r\n		font-size : 11px;\r\n		font-family: verdana, arial, helvetica, sans-serif;\r\n		font-weight: normal;\r\n		font-style: normal;\r\n		text-decoration: none;\r\n		font-weight: none;\r\n		scrollbar-face-color: #999999;\r\n		scrollbar-shadow-color: #FFFFFF;\r\n		scrollbar-highlight-color: #FFFFFF;\r\n		scrollbar-3dlight-color: #999999;\r\n		scrollbar-darkshadow-color: #999999;\r\n		scrollbar-track-color: #999999;\r\n		scrollbar-arrow-color: #FFFFFF;\r\n	}\r\n	.top {\r\n		background-color: #999999;\r\n		color: #FFFFFF;\r\n		font-size : 14px;\r\n		font-family: verdana, arial, helvetica, sans-serif;\r\n		font-style: normal;\r\n		text-decoration: none;\r\n		font-weight: bold;\r\n		text-transform: uppercase;\r\n		letter-spacing: 0.2em;\r\n		padding: 5px;\r\n		margin: 0px;\r\n		width: 100%;\r\n		height: 25px;\r\n		text-align: left;\r\n		border-color: #333333;\r\n		border-style: solid;\r\n		border-top-width: 1px;\r\n		border-left-width: 0px;\r\n		border-right-width: 0px;\r\n		border-bottom-width: 1px;\r\n		position: absolute;\r\n\r\n	top: 100px;\r\n\r\n		left: 0px;\r\n	}\r\n	.log {\r\n		overflow: auto;\r\n		background-color:#FFFFF;\r\n		padding: 5px;\r\n		margin: 0px;\r\n		width: 500px;\r\n\r\n	        height: 391px;\r\n\r\n		border-color: #333333;\r\n		border-style: solid;\r\n		border-top-width: 1px;\r\n		border-left-width: 1px;\r\n		border-right-width: 1px;\r\n		border-bottom-width: 1px;\r\n		position: absolute;\r\n\r\n	top: 150px;\r\n\r\n		left: 25px;\r\n	}\r\n	h3 {\r\n		color: #808080;\r\n		font-size: 12px;\r\n		font-weight: bold;\r\n		text-decoration: underline;\r\n	}\r\n	.text {\r\n		color: #000000;\r\n		width: 90%;\r\n		text-align: left;\r\n	}\r\n	.side {\r\n		background-color:#FFFFFF;\r\n		color: #000000;\r\n		padding: 5px;\r\n		margin: 0px;\r\n		width: 200px;\r\n\r\n	height: 391px;\r\n\r\n		text-align: left;\r\n		border-color: #333333;\r\n		border-style: solid;\r\n		border-top-width: 1px;\r\n		border-left-width: 1px;\r\n		border-right-width: 1px;\r\n		border-bottom-width: 1px;\r\n		position: absolute;\r\n\r\n	top: 150px;\r\n\r\n		left: 550px;\r\n	}\r\n	.bottom {\r\n		background-color: #999999;\r\n		color: #FFFFFF;\r\n		font-size : 14px;\r\n		font-family: verdana, arial, helvetica, sans-serif;\r\n		font-style: normal;\r\n		text-decoration: none;\r\n		font-weight: bold;\r\n		font-transform: lowercase;\r\n		letter-spacing: 0.2em;\r\n		padding: 5px;\r\n		margin: 0px;\r\n		width: 100%;\r\n		height: 25px;\r\n		text-align: right;\r\n		border-color: #333333;\r\n		border-style: solid;\r\n		border-top-width: 1px;\r\n		border-left-width: 0px;\r\n		border-right-width: 0px;\r\n		border-bottom-width: 1px;\r\n		left: 0px;\r\n\r\n\r\n	}\r\n	a:link, a:active, a:visited {\r\n		color: #808080;\r\n		font-weight: none;\r\n		text-decoration: none;\r\n	}\r\n	a:hover {\r\n		text-decoration: underline;\r\n	}\r\n	a.blink:link, a.blink:active, a.blink:visited {\r\n		color: #808080;\r\n		font-weight: bold;\r\n		text-decoration: underline;\r\n	}\r\n	a.blink:hover {\r\n		text-decoration: none;\r\n	}\r\n	-->\r\n	</style>\r\n</head>\r\n\r\n<body leftmargin=\"0\" rightmargin=\"0\" topmargin=\"0\">\r\n\r\n<div class=\"top\"><$Site.Name$></div>\r\n\r\n<div class=\"log\"><div class=\"text\">\r\n<$Main.Body$>\r\n</div></div>\r\n\r\n<div class=\"side\">\r\n	<$Navbar.Vertical$>\r\n	<br>\r\n	<$Side.Column$>\r\n</div>\r\n\r\n</body>\r\n</html>','<p>\r\n<a href=<$Logentry.Url$>><font face=arial size=+1 color=#000000><$Logentry.Title$></font></a>\r\n<br>\r\n<font face=arial size=-1 color=#000000><strong><$Ago.Text$> :: <$Log.Name$></strong></font>\r\n<br>\r\n<font face=arial size=-1 color=#000000><$Logentry.Body$></font>\r\n<br> \r\n<font face=arial size=-2 color=#000000><$Logentry.Datetime.Expanded$> | <$Messages.Count$> Messages | <$Images.Count$> Images</font>','Gray Elephant','dholden84',1,'grayelephant.gif',1),
(40,'<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\r\n<html>\r\n<head>\r\n<style type=\"text/css\">\r\n<!--\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #ffffff;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#ffffff;\r\n	     font-size:25px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#ffffff;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#ffffff;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 2px;\r\n          background-color: #000000;\r\n	      width: 100%}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 2px;\r\n          background-color: #000000;\r\n	  width: 100%}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #ffffff; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #ffffff; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {background-color: #000000;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #ffffff; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {background-color: #000000;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #ffffff; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{background-color: #000000;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #ffffff; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{background-color: #000000;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #ffffff; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{background-color: #999999;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{background-color: #000000;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #ffffff; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{background-color: #000000;\r\n	      FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #ffffff;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{border: solid #000000 1px; \r\n          padding: 0px;\r\n          background-color: #000000;\r\n	      width: 100%}\r\n.caffeinecell{background-color: #000000;}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n--> \r\n</style>\r\n\r\n	<title><$Site.Name$> <$Entry.Title$></title>\r\n</head>\r\n<body bgcolor=#000000 LEFTMARGIN=\'0\' TOPMARGIN=\'0\' MARGINWIDTH=\'0\' MARGINHEIGHT=\'0\'>\r\n<font face=arial size=+3 color=#ffffff><$Site.Name$></font>\r\n<br>\r\n<table cellpadding=0 cellspacing=0 border=0 width=100%>\r\n<td valign=top width=150>\r\n<$Navbar.Vertical$>\r\n</td>\r\n\r\n<td valign=top nowrap>  </td>\r\n\r\n<td valign=top>\r\n<$Main.Body$>\r\n</td>\r\n\r\n<td valign=top nowrap>  </td>\r\n\r\n<td valign=top width=200>\r\n<$Side.Column$>\r\n</td>\r\n</tr>\r\n</table>\r\n</body>\r\n</html>','<p>\r\n<a href=<$Logentry.Url$>><font face=arial size=+1 color=#ffffff><$Logentry.Title$></font></a>\r\n<br>\r\n<font face=arial size=-1 color=#ffffff><strong><$Ago.Text$> :: <$Log.Name$></strong></font>\r\n<br>\r\n<font face=arial size=-1 color=#ffffff><$Logentry.Body$></font>\r\n<br> \r\n<font face=arial size=-2 color=#ffffff><$Logentry.Datetime.Expanded$> | <$Messages.Count$> Messages | <$Images.Count$> Images</font>','Dark as Night','qlogger.com',1,'darkasnight.gif',1),
(41,'<html>\r\n   <head>\r\n      <title><$Site.Name$> <$Entry.Title$></title>\r\n   \r\n\r\n<style type=\"text/css\">\r\n<!--\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:25px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 2px;\r\n          background-color: #cccccc;}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 2px;\r\n          background-color: #333333;}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #ffffff; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {background-color: #333333;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #ffffff; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{background-color: #666666;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{background-color: #ffffff;\r\n	      FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{border: solid #ffffff 1px; \r\n          padding: 0px;\r\n          background-color: #ffffff;\r\n	      width: 100%}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n--> \r\n</style>\r\n\r\n\r\n\r\n      <style type=\"text/css\">\r\n\r\n	body\r\n	{background-color:#000000;\r\n	margin:0px;\r\n	text-align:center;\r\n	font-family:verdana,sans-serif;\r\n	color:#999999;\r\n	font-size:10px;}\r\n\r\n	a\r\n	{color:#0000ff;\r\n	text-decoration:none}\r\n\r\n	p.title\r\n	{color:#8fa1b3;\r\n	text-align:left;\r\n	font-family:arial narrow, arial, sans-serif;\r\n	font-size:22px; \r\n	margin:0px; \r\n	padding:0px;}\r\n\r\n	p.navheader	\r\n	{font-size:12px; \r\n	font-weight:bold; \r\n	border-bottom: 2px solid #fff; \r\n	color:#fff; \r\n	margin:2px; \r\n	padding:0px;}\r\n\r\n	p.date\r\n	{font-size:14px;\r\n	font-wight:bold;\r\n	border-bottom: 2px solid #fff;\r\n	color:#fff;\r\n	margin:3px;\r\n	padding:0px;}\r\n\r\n	p.signature\r\n	{font-size:10px;\r\n	width:100px;\r\n	text-align:right;\r\n	color:#fff;}\r\n\r\n	\r\n	\r\n\r\n      </style>\r\n\r\n   </head>\r\n\r\n   <body>\r\n\r\n<center>\r\n<font face=arial size=+3><$Site.Name$></font>\r\n</center>\r\n<br>\r\n<table cellpadding=0 cellspacing=0 border=0 bgcolor=#000000 width=95%><tr><td>\r\n<table cellpadding=0 cellspacing=1  width=100% border=0>\r\n\r\n<tr>\r\n<td bgcolor=\"#ffcc00\">\r\n<font color=#ffcc00>.</font>\r\n</td>\r\n</tr>\r\n\r\n<tr>\r\n<td bgcolor=#ffffcc>\r\n\r\n<!-- Start Center Inside Table -->\r\n<table cellpadding=0 cellspacing=0 width=100% border=0 bgcolor=#ffffcc><tr><td>\r\n<table cellpadding=0 cellspacing=3 width=100% border=0>\r\n<tr>\r\n<td>\r\n<!-- Start Content Table -->\r\n<table cellpadding=0 cellspacing=0 width=100% border=0 bgcolor=#000000><tr><td>\r\n<table cellpadding=0 cellspacing=1 width=100% border=0>\r\n<tr>\r\n<td valign=top bgcolor=#cccccc width=200>\r\n<$Navbar.Vertical$>\r\n<$Side.Column$>\r\n</td>\r\n<td valign=top bgcolor=#ffffff>\r\n<table cellpadding=5 cellspacing=0 border=0><tr><td>\r\n<$Main.Body$>\r\n</td></tr></table>                                             \r\n</td>\r\n</tr>\r\n</table>\r\n</td></tr></table>\r\n<!-- End Content Table -->\r\n</td>\r\n</tr>\r\n</table>	\r\n</td></tr></table>\r\n<!-- End Center Inside Table -->\r\n</td>\r\n</tr>\r\n\r\n\r\n</table>	\r\n</td></tr></table>\r\n\r\n   </body>\r\n</html>','<!-- Begin Entry --><table width=100% border=0 cellpadding=0 cellspacing=0><tr><td rowspan=2 valign=top width=92><$Ago.Graphic.1$></td><td width=4 rowspan=2 valign=top background=images/box/upperleftcornerbg.gif><img src=images/box/upperleftcorner.gif width=4 height=24></td><td width=100% background=images/box/tophorizontalbar.gif><!-- this gif must be (widthoftable-92) --><img src=images/box/clear.gif width=100% height=4></td><td width=6 rowspan=2 valign=top background=images/box/rightverticalbar.gif><img src=images/box/upperrightcorner.gif width=6 height=24></td></tr><tr><td background=images/box/date.gif valign=middle><img src=images/box/clear.gif width=1 height=20 align=right><img src=images/box/clear.gif width=1 height=13><font size=-2 face=arial><$Logentry.Datetime.Expanded$> :: <$Log.Name$></font></td></tr><tr><td rowspan=5><img src=images/box/leftspacer.gif width=92 height=98></td><td rowspan=4 background=images/box/leftverticalbar.gif><img src=images/box/clear.gif width=4 height=1></td><td background=images/box/topspacer.gif><img src=images/box/clear.gif width=1 height=1></td><td rowspan=4 background=images/box/rightverticalbar.gif><img src=images/box/clear.gif width=6 height=1></td></tr><tr><td background=images/box/title.gif><!-- title --><font size=-1 face=arial><b><a href=<$Logentry.Url$>><$Logentry.Title$></a></b></font><br><img src=images/clear.gif width=10 height=1><font face=arial size=-2></font><br><img src=images/clear.gif width=10 height=1><font face=arial size=-2></font><br><img src=images/box/clear.gif width=6 height=2></td></tr><tr><td background=images/box/bottomspacer.gif><img src=images/box/clear.gif width=1 height=1></td></tr><tr><td><!-- start main content --><font size=-1 face=arial><$Logentry.Body$></font><br><br><font face=arial size=-2><$Messages.Count$> Messages | <$Images.Count$> Images</font><!-- end main content --></td></tr><tr><td valign=top background=images/box/bottomleftcornerbg.gif><img src=images/box/bottomleftcorner.gif width=4 height=6></td><td background=images/box/bottomhorizontalbar.gif><img src=images/box/clear.gif width=1 height=6></td><td valign=top><img src=images/box/bottomrightcorner.gif width=6 height=6></td></tr></table><!-- End Entry -->','Gold and Black','qlogger',1,'goldandblack.gif',1),
(42,'<html>\r\n<head>\r\n\r\n<TITLE><$Site.Name$> <$Entry.Title$></TITLE>\r\n\r\n<style type=\"text/css\">\r\n<!--\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: \"Times New Roman\", Times, serif;\r\n	     color:#000000;\r\n	     font-size:25px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: \"Times New Roman\", Times, serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: \"Times New Roman\", Times, serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 2px;\r\n          background-color: #CCCC99;}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 2px;\r\n          background-color: #CCCC99;}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  \"Times New Roman\", Times, serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  \"Times New Roman\", Times, serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {background-color: #333333;\r\n	      FONT-FAMILY:  \"Times New Roman\", Times, serif;\r\n          font-size: 15px; color: #ffffff; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {background-color: #cccccc;\r\n	      FONT-FAMILY:  \"Times New Roman\", Times, serif;\r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{background-color: #666666;\r\n	      FONT-FAMILY:  \"Times New Roman\", Times, serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{background-color: #cccccc;\r\n	      FONT-FAMILY:  \"Times New Roman\", Times, serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{background-color: #cccccc;\r\n	      FONT-FAMILY:  \"Times New Roman\", Times, serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{background-color: #cccccc;\r\n	      FONT-FAMILY:  \"Times New Roman\", Times, serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{background-color: #ffffff;\r\n	      FONT-FAMILY: \"Times New Roman\", Times, serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{border: solid #EFEFEF 1px; \r\n          padding: 0px;\r\n          background-color: #EFEFEF;\r\n	      width: 100%}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n--> \r\n</style>\r\n\r\n\r\n\r\n<style type=\"text/css\">\r\na{ text-decoration: none; color:#333333;}\r\n.subject     { color: #666666; font-size: 8pt; letter-spacing: 1; font-weight: bold; text-align:left }\r\n.byline      { font-family: \"Times New Roman\", Times, serif; color: #999999; font-size: 10px; text-align: right }\r\n.byline  a:link      { font-family: \"Times New Roman\", Times, serif; color: #999999; font-size: 10px; text-align: right  }\r\n.byline  a:visited     { font-family: \"Times New Roman\", Times, serif; color: #999999; font-size: 10px; text-align: right  }\r\n.byline  a:hover     { font-family: \"Times New Roman\", Times, serif; color: #000000; font-size: 10px; text-align: right  }\r\n.post        { color: #666666; font-family: \"Times New Roman\", Times, serif; font-size: 8pt; text-align: justify }\r\n.post  a:hover { text-decoration: none; color:#333333;   }\r\n.post  a:visited {  text-decoration: none;color: #91A9C1; color:#999999;   }\r\n.post  a:link {  text-decoration: none;color: #91A9C1; color:#333333; font-variant:small-caps  }\r\n.date        { font-family: \"Times New Roman\", Times, serif; color: #333333; font-size: 12pt; \r\n               font-weight:bold; text-align:right; text-transform:uppercase }\r\n</style>\r\n<!-- END STYLE SHEET INFORMATION -->\r\n</head>\r\n\r\n<body  bgcolor=\"#6F6F6F\" style=\"font-family: Arial\">\r\n\r\n<div align=\"center\">\r\n  <center>\r\n\r\n<table cellpadding=7 cellspacing=0 border=0 width=80%  bgcolor=\"#FFFFFF\" style=\"border-collapse: collapse; border: 1px solid #333333\" bordercolor=\"#333333\">\r\n<tr>\r\n	<td colspan=2 bgcolor=\"#97B8CA\" width=600>\r\n\r\n	<p class=\"headers\"><b><font size=\"3\" face=\"Georgia\" color=\"#333333\"><$Site.Name$></font></b></p>\r\n\r\n	</td>\r\n</tr>\r\n<tr>\r\n	<td width=20 rowspan=3 bgcolor=\"#97B8CA\">\r\n	 \r\n	</td>\r\n	<td align=right width=580 bgcolor=\"#CCCC99\" style=\"border-left:1px solid #333333; border-top:1px solid #333333; border-bottom:1px solid #333333; \">\r\n		<p align=\"left\"><span class=\"dis\">\r\n        <font size=\"1\" face=\"Verdana\" color=\"#333333\"><$Site.Description$></font></span></td>\r\n</tr>\r\n\r\n<tr>\r\n	<td class=\"c\" bgcolor=\"#CCCC99\" style=\"border-left:1px solid #333333; border-top:1px solid #333333; \">\r\n	<p align=\"center\" class=\"byline\" style=\"text-align: center\">\r\n    <$Navbar.Horizontal$>\r\n	</td>\r\n</tr>\r\n\r\n<tr>\r\n	<td style=\"border-left:1px solid #464646; \" bgcolor=\"#EFEFEF\">\r\n		<table cellpadding=0 cellspacing=0 border=0 width=\"100%\" style=\"border-collapse: collapse\" bordercolor=\"#333333\">\r\n			<tr>\r\n				<td width=\"75%\" align=\"left\" valign=\"top\" bgcolor=\"#EFEFEF\" style=\"text-align: justify\">\r\n			     <$Main.Body$>\r\n</td>\r\n<td width=5%> </td>\r\n			<td align=\"center\" width=\"20%\" valign=\"top\">\r\n			<div align=\"right\">\r\n			<$Side.Column$>\r\n			</div>\r\n			</td>\r\n		</tr>\r\n		</table>\r\n	</td>\r\n</tr>\r\n\r\n\r\n</table>\r\n\r\n  </center>\r\n</div>\r\n\r\n</body>\r\n</html>','<div class=\"date\"><a href=<$Logentry.Url$>> <$Logentry.Title$></a></div>\r\n<div class=\"subject\"><$Ago.Text$> :: <$Logentry.Datetime.Expanded$></div>\r\n<div class=\"post\"><$Logentry.Body$></div>\r\n<div class=\"byline\"><$Messages.Count$> Messages | <$Images.Count$> Images</a></div><br>','Grey Blue Tan','qlogger.com',1,'greybluetan.gif',1),
(43,'<html>\r\n<head>\r\n  <title><$Site.Name$> <$Entry.Title$></title>\r\n\r\n<style>\r\n/* ++++++++++++++++++++ This is the stylesheet that controls elements that are output by the system.  The names are pre-defined.  They may make little sense to you at first.  Play with them.  Change one to a funky color and then visit your site to see how it looks.  If you get in trouble, simply go to the Template Gallery and start over with one of the stylish pre-built templates. Have fun and be creative! You\'re in control. */\r\n\r\n\r\n/* The color of links on your site. */\r\na       {color: #000000;  font-weight: bold;}\r\n\r\n/* A big font used throughout the site in various places. */\r\n.bigfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:25px;}\r\n\r\n/* A medium font used throughout the site in various places. */\r\n.mediumfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#000000;\r\n	     font-size:10px;}\r\n\r\n/* A small font used throughout the site in various places. */\r\n.smallfont{font-family: verdana, arial, helvetica, sans-serif;\r\n	     color:#666666;\r\n	     font-size:10px;}\r\n\r\n/* The table that houses your main log navigation. */\r\n.navigation{width: 100%;background-color: #cccccc;}\r\n\r\n/* The style of a navigation button that is currently clicked off. This will determine the general color and style of your navigation bar. */\r\n.navcelloff{padding: 2px;\r\n          background-color: #cccccc;\r\n	      width: 100%}\r\n	  \r\n/* The style of a navigation button that is currently clicked on. */\r\n.navcellon{padding: 2px;\r\n          background-color: #ffcc00;\r\n	  width: 100%}\r\n\r\n/* The font used when a navigation bar button is turned off. */\r\n.navfontoff{FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* The font used when a navigation bar button is turned on. */\r\n.navfonton{FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Content in your side column is arranged into units. */\r\n.sidecolunit {width: 100%}\r\n		  \r\n/* The background and font for unit headers in your side column. */\r\n.sidecolheader {background-color: #ffcc00;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 15px; color: #000000; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n		  \r\n/* The background and font for content in your side column. */\r\n.sidecolcontent {background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif;\r\n          font-size: 10px; color: #334C66; \r\n          font-weight: bold;\r\n	      width: 100%}\r\n\r\n/* Sun Mon Tue Wed Thu Fri Sat.  This changes the font and background color. */\r\n.calendardayname{background-color: #999999;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 8px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* 1 2 3...  the little numbers in your calendar.  This changes the font and background color. */\r\n.calendardaybox{background-color: #ffffcc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n		  \r\n/* The current day in your calendar.  This changes the font and background color so that you can highlight it. */\r\n.calendardayboxtoday{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of field names.*/		 \r\n.logentryheader{background-color: #cccccc;\r\n	      FONT-FAMILY:  verdana, arial, helvetica, sans-serif; \r\n          font-size: 12px; color: #000000; \r\n          font-weight: bold;}\r\n\r\n/* Important for setting the style of your log entry detail page. This controls the display of your data. */	\r\n.logentrycontent{background-color: #ffffff;\r\n	      FONT-FAMILY: verdana, arial, helvetica, sans-serif; \r\n          font-size: 10px; color: #000000;}\r\n\r\n/* Control the little numbers that appear when you list more log entries than will appear on the page. */	\r\n.pagingnumbers{padding: 0px;\r\n          background-color: #cccccc;\r\n	      width: 100%}\r\n\r\n/* ++++++++++++++++++++ Below this point are css classes that appear in the template itself.  You can add/remove classes by editing your template directly. */\r\n		  \r\n</style>\r\n\r\n</head>\r\n<body bgcolor=\"#333333\" text=\"#000000\" link=\"#0000ff\" vlink=\"#0000ff\">\r\n<center>\r\n<table cellpadding=0 cellspacing=0 border=0 bgcolor=#000000 width=95%><tr><td>\r\n<table cellpadding=3 cellspacing=2 border=0 width=100%>\r\n\r\n<tr>\r\n<td colspan=3 valign=bottom align=right bgcolor=\"#ffcc00\" background=\"images/template/tiledbgimages/flowers03.jpg\">\r\n<br><br><br><font face=arial size=+3><b><$Site.Name$></b></font>\r\n</td>\r\n</tr>\r\n\r\n<tr>\r\n<td valign=top bgcolor=\"#cccccc\" width=150>\r\n<$Navbar.Vertical$>\r\n</td>\r\n<td valign=top bgcolor=#ffffff>\r\n<$Main.Body$>\r\n</td>\r\n<td valign=top bgcolor=#cccccc width=200 align=center>\r\n<$Side.Column$>\r\n</td>\r\n</tr>\r\n\r\n</table></td></tr></table>\r\n</center>\r\n</body>\r\n</html>','<!-- Begin Entry --><table width=100% border=0 cellpadding=0 cellspacing=0><tr><td rowspan=2 valign=top width=92><$Ago.Graphic.1$></td><td width=4 rowspan=2 valign=top background=images/box/upperleftcornerbg.gif><img src=images/box/upperleftcorner.gif width=4 height=24></td><td width=100% background=images/box/tophorizontalbar.gif><!-- this gif must be (widthoftable-92) --><img src=images/box/clear.gif width=100% height=4></td><td width=6 rowspan=2 valign=top background=images/box/rightverticalbar.gif><img src=images/box/upperrightcorner.gif width=6 height=24></td></tr><tr><td background=images/box/date.gif valign=middle><img src=images/box/clear.gif width=1 height=20 align=right><img src=images/box/clear.gif width=1 height=13><font size=-2 face=arial><$Logentry.Datetime.Expanded$> :: <$Log.Name$></font></td></tr><tr><td rowspan=5><img src=images/box/leftspacer.gif width=92 height=98></td><td rowspan=4 background=images/box/leftverticalbar.gif><img src=images/box/clear.gif width=4 height=1></td><td background=images/box/topspacer.gif><img src=images/box/clear.gif width=1 height=1></td><td rowspan=4 background=images/box/rightverticalbar.gif><img src=images/box/clear.gif width=6 height=1></td></tr><tr><td background=images/box/title.gif><!-- title --><font size=-1 face=arial><b><a href=<$Logentry.Url$>><$Logentry.Title$></a></b></font><br><img src=images/clear.gif width=10 height=1><font face=arial size=-2></font><br><img src=images/clear.gif width=10 height=1><font face=arial size=-2></font><br><img src=images/box/clear.gif width=6 height=2></td></tr><tr><td background=images/box/bottomspacer.gif><img src=images/box/clear.gif width=1 height=1></td></tr><tr><td><!-- start main content --><font size=-1 face=arial><$Logentry.Body$></font><br><br><font face=arial size=-2><$Messages.Count$> Messages | <$Images.Count$> Images</font><!-- end main content --></td></tr><tr><td valign=top background=images/box/bottomleftcornerbg.gif><img src=images/box/bottomleftcorner.gif width=4 height=6></td><td background=images/box/bottomhorizontalbar.gif><img src=images/box/clear.gif width=1 height=6></td><td valign=top><img src=images/box/bottomrightcorner.gif width=6 height=6></td></tr></table><!-- End Entry -->','Reaching for the Sun','qlogger.com',1,'reachingforthesun.gif',1);


/*
Table structure for trackback
*/

CREATE TABLE `trackback` (
  `trackbackid` int(11) NOT NULL auto_increment,
  `eventid` int(11) NOT NULL default '0',
  `isoutbound` int(11) default NULL,
  `ispingedalready` int(11) NOT NULL default '0',
  `url` varchar(255) default NULL,
  `blogname` varchar(255) default NULL,
  `posttitle` varchar(255) default NULL,
  `excerpt` varchar(255) default NULL,
  `datetime` datetime default NULL,
  `isapproved` int(11) NOT NULL default '0',
  PRIMARY KEY  (`trackbackid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*
Table structure for traffic
*/

CREATE TABLE `traffic` (
  `trafficid` int(11) NOT NULL auto_increment,
  `count` int(11) default NULL,
  `traffictypeid` int(11) default NULL,
  `datetime` datetime default NULL,
  `url` varchar(255) default NULL,
  `plid` int(11) default NULL,
  `accountid` int(11) default NULL,
  `logid` int(11) default NULL,
  `eventid` int(11) default NULL,
  `imageid` int(11) default NULL,
  `referrer` varchar(255) default NULL,
  `browser` varchar(255) default NULL,
  `remotehost` varchar(255) default NULL,
  `iscollapsed` int(11) default NULL,
  PRIMARY KEY  (`trafficid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*
Table structure for vstransaction
*/

CREATE TABLE `vstransaction` (
  `vstransactionid` int(11) NOT NULL auto_increment,
  `accountid` int(11) default NULL,
  `datetime` datetime default NULL,
  `vssentstring` longtext,
  `vsresultstring` longtext,
  `hostaddress` varchar(50) default NULL,
  `result` varchar(50) default NULL,
  `acct` varchar(50) default NULL,
  `amt` varchar(50) default NULL,
  `street` varchar(50) default NULL,
  `zip` varchar(50) default NULL,
  `rpref` varchar(50) default NULL,
  `profileid` varchar(50) default NULL,
  PRIMARY KEY  (`vstransactionid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
