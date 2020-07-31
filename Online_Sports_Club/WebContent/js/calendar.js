/***************************************************************************
 * calendar.js
 * August.27.2007
 ***************************************************************************
 * This calendar is developed by Sarfraz Qasim.
 * This script is totally free to use for any purpose.
 * For report bugs Please mail at sarfraz@design2develop.com.
 * For complete documentation please visit www.design2develop.com/calendar
 ***************************************************************************/

var oGlobalArray = new Array();

function fnInitCalendar(oTarget, sInputID, sCustom)
{
	//var oEvent = arguments.callee.caller.arguments[0] || window.event;
	//var oTarget = oEvent.target || oEvent.srcElement;
	oTarget.style.cursor = 'pointer';
	oTarget.onclick = function(e) {
		_fnSetCalendar(e, sInputID, sCustom);
	};
}

function _fnSetCalendar(e, sInputID, sCustom)
{
	var oCalendarArray	= new Array();
	var oInput			= window.document.getElementById(sInputID);
	var oEvent			= e || window.event;
	var sDivId			= '_div' + sInputID;
	var oDiv			= window.document.getElementById(sDivId);
	var oDay			= _fnGetWeekDays();
	var oDate			= new Date();
	var bDrag			= true;
	var bClose			= false;
	var bExpiry			= false;
	var iDayElapse		= 0;
	var bRestrict		= false;
	var iDayLimit		= 0;
	var bDropHide		= false;
	var oDropArray		= new Array();
	var iTop			= 5;
	var iLeft			= 5;
	
	if(!oDiv)
	{
		oDiv			= window.document.createElement('div');
		oDiv.id			= sDivId;
		oDiv.className	= 'mainDiv_';
		oDiv.name		= 'calendar';
		oDiv.style.position	= 'absolute';
		window.document.body.appendChild(oDiv);
	}

	if(sCustom != undefined || sCustom != '')
	{
		sCustom = String(sCustom).toLowerCase();
		if(sCustom.indexOf('year') != -1)
		{
			var sYear = _fnGetValue(sCustom, 'year');
			if(sYear.length == 4 && !isNaN(Number(sYear)))
				oDate.setFullYear(sYear);
		}
		if(sCustom.indexOf('month') != -1)
		{
			var sMonth = _fnGetValue(sCustom, 'month');
			if(sMonth.length < 3 && sMonth > 0 && !isNaN(Number(sMonth)))
				oDate.setMonth(sMonth - 1);
		}
		if(sCustom.indexOf('top') != -1)
		{
			var sTop = _fnGetValue(sCustom, 'top');
			if(!isNaN(Number(sTop)))
				iTop = Number(sTop);
		}
		if(sCustom.indexOf('left') != -1)
		{
			var sLeft = _fnGetValue(sCustom, 'left');
			if(!isNaN(Number(sLeft)))
				iLeft = Number(sLeft);
		}
		if(sCustom.indexOf('drag') != -1)
		{
			var sDrag = _fnGetValue(sCustom, 'drag');
			if(sDrag == 'true' || sDrag == 'false')
			{
				bDrag = window.eval(sDrag);
			}
		}
		if(sCustom.indexOf('close') != -1)
		{
			var sClose = _fnGetValue(sCustom, 'close');
			if(sClose == 'true' || sClose == 'false')
			{
				bClose = window.eval(sClose);
			}
		}
		if(sCustom.indexOf('expiry') != -1)
		{
			var bExpiry = _fnGetValue(sCustom, 'expiry');
			if(bExpiry == 'true' || bExpiry == 'false')
			{
				bExpiry = window.eval(bExpiry);
			}
		}
		if(sCustom.indexOf('elapse') != -1)
		{
			var sDayElapse = _fnGetValue(sCustom, 'elapse');
			if(!isNaN(Number(sDayElapse)))
				iDayElapse = Number(sDayElapse);
		}
		if(sCustom.indexOf('restrict') != -1)
		{
			var bRestrict = _fnGetValue(sCustom, 'restrict');
			if( bRestrict == 'true' ||  bRestrict == 'false')
			{
				 bRestrict = window.eval( bRestrict);
			}
		}
		if(sCustom.indexOf('limit') != -1)
		{
			var sDayLimit = _fnGetValue(sCustom, 'limit');
			if(!isNaN(Number(sDayLimit)))
				iDayLimit = Number(sDayLimit);
		}
		if(sCustom.indexOf('style') != -1)
		{
			var sStyle = _fnGetValue(sCustom, 'style');
			if(sStyle.indexOf('.css') != -1)
			{
				var oLink = window.document.getElementsByTagName('link');
				var oStyle;
				for(var iCounter = 0; iCounter < oLink.length; iCounter++)
				{
					if(oLink[iCounter].title == 'calendar')
					{
						oStyle = oLink[iCounter];
						break;
					}
				}
				var sStylePath = '';
				if(String(oStyle.href).lastIndexOf('/') != -1)
				{
					var iSlashIndex	= String(oStyle.href).lastIndexOf('/');
					sStylePath		= String(oStyle.href).substring(0, iSlashIndex+1);
				}
				oStyle.href = sStylePath + sStyle;
			}
		}
		if(sCustom.indexOf('instance') != -1)
		{
			var sInstance = _fnGetValue(sCustom, 'instance');
			if(sInstance == 'single')
			{
				var oDivs = window.document.getElementsByTagName('div');
				for(var iCounter = 0; iCounter < oDivs.length; iCounter++)
				{
					if(oDivs[iCounter].name == 'calendar')
					{
						oDivs[iCounter].style.display = 'none';
					}
				}
			}
		}
		if(sCustom.indexOf('dropdown') != -1)
		{
			if(String(window.navigator.appName).indexOf('Microsoft') != -1)
			{
				var sDrop = _fnGetValue(sCustom, 'dropdown');
				if(sDrop == 'hide')
				{
					var oElements = window.document.getElementsByTagName('select');
					for(var iCounter = 0; iCounter < oElements.length; iCounter++)
					{
						if(oElements[iCounter].style.display != 'none')
						{
							oElements[iCounter].style.display = 'none';
							oDropArray.push(oElements[iCounter]);
						}
					}
					bDropHide = true;
				}
			}
		}
	}

	if(window.document.documentElement.scrollTop > 0)
	{
		oDiv.style.top  = (parseInt(oEvent.clientY) + parseInt(window.document.documentElement.scrollTop)  + parseInt(iTop))  + 'px';
		oDiv.style.left = (parseInt(oEvent.clientX) + parseInt(window.document.documentElement.scrollLeft) + parseInt(iLeft)) + 'px';
	}
	else
	{
		oDiv.style.top  = (parseInt(oEvent.clientY) + parseInt(window.document.body.scrollTop)  + parseInt(iTop))  + 'px';
		oDiv.style.left = (parseInt(oEvent.clientX) + parseInt(window.document.body.scrollLeft) + parseInt(iLeft)) + 'px';
	}	
	if(bDrag)
	{
		Drag.init(oDiv);
	}
	
	oCalendarArray['Input']		= oInput;
	oCalendarArray['Div']		= oDiv;
	oCalendarArray['Date']		= oDate;
	oCalendarArray['Day']		= oDay;
	oCalendarArray['Drag']		= bDrag;
	oCalendarArray['Close']		= bClose;
	oCalendarArray['Expiry']	= bExpiry;
	oCalendarArray['Elapse']	= iDayElapse;
	oCalendarArray['Restrict']	= bRestrict;
	oCalendarArray['Limit']		= iDayLimit;
	oCalendarArray['Drop']		= bDropHide;
	oCalendarArray['Selects']	= oDropArray;

	var iIndex = _fnAddCalendarArray(oCalendarArray);
	_fnCreateCalendar(iIndex);
}



function _fnCreateCalendar(iIndex)
{
	var oCalendarArray	= oGlobalArray[iIndex];
	var sYear			= oCalendarArray['Date'].getFullYear();
	var sMonth			= oCalendarArray['Date'].getMonth();
	var oLayout			= new Array();	
	
	oLayout.push(_fnGetTitleRow(iIndex));
	oLayout.push(_fnGetYearRow(iIndex));
	oLayout.push(_fnGetMonthRow(iIndex));
	oLayout.push(_fnGetCalendarRows(iIndex));

	oLayout.push("</table>");

	oCalendarArray['Div'].innerHTML = oLayout.join('');
	oCalendarArray['Div'].style.display = 'inline';
	oCalendarArray, sYear, sMonth, oLayout = null;
}


function _fnGetTitleRow(iIndex)
{
	var oCalendarArray	= oGlobalArray[iIndex];
	var oRowLayout		= new Array();
	var sCursor			= 'cursor:move';
	
	if(!oCalendarArray['Drag'])
		sCursor			= 'cursor:default';

	oRowLayout.push("<table cellspacing='1' cellpadding='0' border='0' class='calendarTable_' onMouseDown=\"_fnMoveDivAbove('"+iIndex+"')\">");
	oRowLayout.push("<tr>");
	oRowLayout.push("<td align='center' valign='middle' colspan='"+oCalendarArray['Day'].length+"' style='"+sCursor+"'>");

	oRowLayout.push("<table cellspacing='0' cellpadding='2' border='0' width='100%'>");
	oRowLayout.push("<tr>");
	oRowLayout.push("<td align='left' valign='middle' class='titleRow_' width='90%'>");
	oRowLayout.push("Calendar :.</td>");
	oRowLayout.push("<td align='right' valign='middle' class='titleRow_'>");
	oRowLayout.push("<a href=\"javascript:_fnClearValue('"+iIndex+"')\" title='Clear Date Value from Input' class='linksButton_'>C</a></td>");
	oRowLayout.push("<td align='right' valign='middle' class='titleRow_'>");
	oRowLayout.push("<a href=\"javascript:_fnCloseCalendar('"+iIndex+"')\" title='Close Calendar' class='linksButton_'>X</a></td>");
	oRowLayout.push("</tr>");
	oRowLayout.push("</table>");
	
	oRowLayout.push("</td>");
	oRowLayout.push("</tr>");

	return oRowLayout.join('');
	oCalendarArray = null;
}



function _fnGetYearRow(iIndex)
{
	var oCalendarArray	= oGlobalArray[iIndex];
	var iYear			= window.parseInt(oCalendarArray['Date'].getFullYear(), 10);
	var iPreviousYear	= iYear - 1;		
	var iNextYear		= iYear + 1;		
	var oRowLayout		= new Array();

	oRowLayout.push("<tr>");
	oRowLayout.push("<td align='center' valign='middle' colspan='"+oCalendarArray['Day'].length+"' class='yearHeadingRow_'>");

	oRowLayout.push("<table cellspacing='0' cellpadding='0' border='0' width='100%' class='yearHeadingRow_'>");
	oRowLayout.push("<tr>");
	oRowLayout.push("<td align='center' valign='middle' width='15'>");
	oRowLayout.push("<a href=\"javascript:_fnGetSelectedYear('"+iIndex+"', '"+iPreviousYear+"')\"");
	oRowLayout.push(" title='Previous Year "+iPreviousYear+"' class='linksCalendar_'>&lt;</a></td>");
	oRowLayout.push("<td align='center' valign='middle'>");
	oRowLayout.push("Year " + iYear);
	oRowLayout.push("</td>");
	oRowLayout.push("<td align='center' valign='middle' width='12'>");
	oRowLayout.push("<a href=\"javascript:_fnShowYears('"+iIndex+"')\" title='Select Year' class='linksCalendar_' style='font-size:10px'>v</a></td>");
	oRowLayout.push("<td align='center' valign='middle' width='15'>");
	oRowLayout.push("<a href=\"javascript:_fnGetSelectedYear('"+iIndex+"', '"+iNextYear+"')\"");
	oRowLayout.push(" title='Next Year "+iNextYear+"' class='linksCalendar_'>&gt;</a></td>");
	oRowLayout.push("</tr>");
	oRowLayout.push("</table>");

	oRowLayout.push("</td>");
	oRowLayout.push("</tr>");

	return oRowLayout.join('');
}


function _fnGetMonthRow(iIndex)
{
	var oCalendarArray	= oGlobalArray[iIndex];
	var iMonth			= parseInt(oCalendarArray['Date'].getMonth(), 10);
	var sPreviousMonth	= _fnGetCalendarMonth(iMonth - 1);	
	var sNextMonth		= _fnGetCalendarMonth(iMonth + 1);	
	
	var sCurrentMonth	= _fnGetCalendarMonth(iMonth);
	var oRowLayout		= new Array();

	oRowLayout.push("<tr>");
	oRowLayout.push("<td align='center' valign='middle' colspan='"+oCalendarArray['Day'].length+"' class='monthHeadingRow'>");

	oRowLayout.push("<table cellspacing='0' cellpadding='1' border='0' width='100%'>");
	oRowLayout.push("<tr class='monthHeadingRow_'>");
	oRowLayout.push("<td align='center' valign='middle' width='15'>");

	if(sPreviousMonth == undefined)
	{
		sPreviousMonth = _fnGetCalendarMonth(11);
	}
	oRowLayout.push("<a href=\"javascript:_fnGetSelectedMonth('"+iIndex+"', '"+(iMonth - 1)+"')\"");
	oRowLayout.push(" title='Previous Month "+sPreviousMonth+"' class='linksCalendar_'>&lt;</a>");

	oRowLayout.push("</td>");
	oRowLayout.push("<td align='center' valign='middle'>");
	oRowLayout.push(sCurrentMonth);
	oRowLayout.push("</td>");
	oRowLayout.push("<td align='center' valign='middle' width='5'>");
	oRowLayout.push("<a href=\"javascript:_fnShowAllMonths('"+iIndex+"')\" title='Select Month' class='linksCalendar_' style='font-size:10px'>v</a></td>");
	oRowLayout.push("<td align='center' valign='middle' width='15'>");

	if(sNextMonth == undefined)
	{
		sNextMonth = _fnGetCalendarMonth(0);
	}
	oRowLayout.push("<a href=\"javascript:_fnGetSelectedMonth('"+iIndex+"', '"+(iMonth + 1)+"')\"");
	oRowLayout.push(" title='Next Month "+sNextMonth+"' class='linksCalendar_'>&gt;</a>");

	oRowLayout.push("</td>");
	oRowLayout.push("</tr>");
	oRowLayout.push("</table>");

	oRowLayout.push("</td>");
	oRowLayout.push("</tr>");
	
	return oRowLayout.join('');
}


function _fnGetCalendarRows(iIndex)
{
	var oCalendarArray	= oGlobalArray[iIndex];
	var oRowLayout 		= new Array();

	oRowLayout.push("<tr>");

	for(counter = 0; counter < oCalendarArray['Day'].length; counter++)
	{
		oRowLayout.push("<td align='center' valign='middle' class='daysHeadingCell_'>");
		oRowLayout.push(oCalendarArray['Day'][counter].substring(0, 2) + "</td>");
	}

	oRowLayout.push("</tr>");

	var oDate		= new Date();
	var iCurrYear	= oDate.getFullYear();
	var iCurrMonth	= oDate.getMonth();
	var iCurrDate	= oDate.getDate();
	
	var iDayElapse	= (60 * 60 * 24 * 1000) * oCalendarArray['Elapse']; //No of Day
	var iExpiryDate	= window.parseInt(oDate.getTime()) + iDayElapse;
	var iDayLimit	= (60 * 60 * 24 * 1000) * oCalendarArray['Limit']; //No of Day
	var iLimitDate	= window.parseInt(oDate.getTime()) + iDayLimit;
	
	var iYear	= oCalendarArray['Date'].getFullYear();
	var iMonth	= oCalendarArray['Date'].getMonth();
	
	var oTmpDate	= new Date();				
	oTmpDate.setDate(1);
	oTmpDate.setMonth(iMonth);
	oTmpDate.setFullYear(iYear);
	
	var iFirstDay			= oTmpDate.getDay();
	var iNumberOfDays		= _fnGetDaysCount(iMonth, iYear);
	var iDaysLoopCounter	= Math.ceil((iFirstDay + iNumberOfDays) / oCalendarArray['Day'].length);

	var iCellCounter = 0;
	var iDateCounter = 0;
	var iCalendarDay = 0;
	
	for(counter = 0; counter < iDaysLoopCounter; counter++)
	{
		oRowLayout.push("<tr>");
		for(count = 0; count < oCalendarArray['Day'].length; count++)
		{
			if(iCellCounter < iFirstDay || iDateCounter >= iNumberOfDays)
			{
				oRowLayout.push("<td align='center' valign='middle' class='blankCell_'>");
				oRowLayout.push("&nbsp;</td>");
			}
			else
			{
				iDateCounter++;
				iCalendarDay = iDateCounter;
				
				oTmpDate.setDate(iDateCounter);
				
				if(oCalendarArray['Expiry'] == true && oCalendarArray['Restrict'] == true) //for Range
				{
					if(iExpiryDate <= oTmpDate.getTime() && iLimitDate >= oTmpDate.getTime())
					{
						if(iYear == iCurrYear && iMonth == iCurrMonth && iDateCounter == iCurrDate)
							oRowLayout.push("<td class='todayDateCell_' onMouseOver=this.className='dateOver_' onMouseOut=this.className='todayDateCell_'");
						else if(count == 0)	
							oRowLayout.push("<td class='sundayDateCell_' onMouseOver=this.className='dateOver_' onMouseOut=this.className='sundayDateCell_'");
						else
							oRowLayout.push("<td class='normalDateCell_' onMouseOver=this.className='dateOver_' onMouseOut=this.className='normalDateCell_'");
					
						oRowLayout.push(" onclick=\"_fnAssignDate('"+iIndex+"', this.innerHTML)\"");
						oRowLayout.push(">" + iDateCounter + "</td>");
					}
					else
					{
						oRowLayout.push("<td align='center' valign='middle' class='disabledCell_'>");
						oRowLayout.push(iDateCounter + "</td>");
					}	
				}
				else if(oCalendarArray['Expiry'] == true) //for Expiry
				{
					if(iExpiryDate <= oTmpDate.getTime())
					{
						if(iYear == iCurrYear && iMonth == iCurrMonth && iDateCounter == iCurrDate)
							oRowLayout.push("<td class='todayDateCell_' onMouseOver=this.className='dateOver_' onMouseOut=this.className='todayDateCell_'");
						else if(count == 0)	
							oRowLayout.push("<td class='sundayDateCell_' onMouseOver=this.className='dateOver_' onMouseOut=this.className='sundayDateCell_'");
						else
							oRowLayout.push("<td class='normalDateCell_' onMouseOver=this.className='dateOver_' onMouseOut=this.className='normalDateCell_'");
					
						oRowLayout.push(" onclick=\"_fnAssignDate('"+iIndex+"', this.innerHTML)\"");
						oRowLayout.push(">" + iDateCounter + "</td>");
					}
					else
					{
						oRowLayout.push("<td align='center' valign='middle' class='disabledCell_'>");
						oRowLayout.push(iDateCounter + "</td>");
					}	
				}
				else if(oCalendarArray['Restrict'] == true) //for Limit
				{
					if(iLimitDate >= oTmpDate.getTime())
					{
						if(iYear == iCurrYear && iMonth == iCurrMonth && iDateCounter == iCurrDate)
							oRowLayout.push("<td class='todayDateCell_' onMouseOver=this.className='dateOver_' onMouseOut=this.className='todayDateCell_'");
						else if(count == 0)	
							oRowLayout.push("<td class='sundayDateCell_' onMouseOver=this.className='dateOver_' onMouseOut=this.className='sundayDateCell_'");
						else
							oRowLayout.push("<td class='normalDateCell_' onMouseOver=this.className='dateOver_' onMouseOut=this.className='normalDateCell_'");
					
						oRowLayout.push(" onclick=\"_fnAssignDate('"+iIndex+"', this.innerHTML)\"");
						oRowLayout.push(">" + iDateCounter + "</td>");
					}
					else
					{
						oRowLayout.push("<td align='center' valign='middle' class='disabledCell_'>");
						oRowLayout.push(iDateCounter + "</td>");
					}	
				}
				else
				{
					if(iYear == iCurrYear && iMonth == iCurrMonth && iDateCounter == iCurrDate)
						oRowLayout.push("<td class='todayDateCell_' onMouseOver=this.className='dateOver_' onMouseOut=this.className='todayDateCell_'");
					else if(count == 0)	
						oRowLayout.push("<td class='sundayDateCell_' onMouseOver=this.className='dateOver_' onMouseOut=this.className='sundayDateCell_'");
					else
						oRowLayout.push("<td class='normalDateCell_' onMouseOver=this.className='dateOver_' onMouseOut=this.className='normalDateCell_'");
			
					oRowLayout.push(" onclick=\"_fnAssignDate('"+iIndex+"', this.innerHTML)\"");
					oRowLayout.push(">" + iDateCounter + "</td>");
				}	
			}

			iCellCounter++;
		}
		oRowLayout.push("</tr>");
	}
	return oRowLayout.join('');
}

function _fnGetSelectedYear(iIndex, iYear)
{
	var oCalendarArray		= oGlobalArray[iIndex];
	var oDate				= oCalendarArray['Date'];

	oDate.setFullYear(iYear);
	oCalendarArray['Date']	= oDate;
	oGlobalArray[iIndex]	= oCalendarArray;
	_fnCreateCalendar(iIndex);
	oCalendarArray			= null;
}

function _fnGetSelectedMonth(iIndex, iMonth)
{
	var oCalendarArray		= oGlobalArray[iIndex];
	var oDate				= oCalendarArray['Date'];
	
	if(Number(oDate.getDate()) == 31)
		oDate.setDate(oDate.getDate()+1)
	else
		oDate.setMonth(iMonth);

	oCalendarArray['Date']	= oDate;
	oGlobalArray[iIndex]	= oCalendarArray;
	_fnCreateCalendar(iIndex);
	oCalendarArray			= null;
}


function _fnShowYears(iIndex, sPrevious, sNext)
{
	var oCalendarArray	= oGlobalArray[iIndex];
	var iRecordPerRow	= 3;
	var iRowCounter		= 0;
	var iYears			= 15;
	var iCurrentYear;

	if(sPrevious == undefined && sNext == undefined)
	{
		iCurrentYear = oCalendarArray['Date'].getFullYear();
	}
	else
	{
		iCurrentYear = (sPrevious == undefined) ? sNext : sPrevious;
	}

	iCurrentYear = parseInt(iCurrentYear, 10);

	//if(iCurrentYear < 1900) iCurrentYear = 2000;
	//else if(iCurrentYear > 2100) iCurrentYear = 2000;

	sPrevious	= iCurrentYear - 15;
	sNext		= iCurrentYear + 15;


	var oLayout	= new Array();

	oLayout.push(_fnGetTitleRow(iIndex));
	oLayout.push(_fnGetYearRow(iIndex));
	oLayout.push(_fnGetSelectedYearRows(iIndex, sPrevious, sNext));

	for(iCounter = 0; iCounter < iYears; iCounter++)
	{
		if(iRowCounter % iRecordPerRow == 0) oLayout.push("<tr>");

		oLayout.push("<td width='"+Math.floor((iYears / iRecordPerRow) * 100)+"' class='yearCell_' onmouseover=\"this.className='yearOver_'\" onmouseout=\"this.className='yearCell_'\" onclick=\"_fnGetSelectedYear('"+iIndex+"', this.innerHTML)\">");
		oLayout.push(iCurrentYear + "</td>");

		iCurrentYear++;
		iRowCounter++;
		if(iRowCounter % iRecordPerRow == 0) oLayout.push("</tr>");
	}

	oLayout.push("</table>");

	oCalendarArray['Div'].innerHTML		= oLayout.join('');
	oCalendarArray['Div'].style.display	= 'inline';
	oCalendarArray, iRecordPerRow, iRowCounter, iYears, iCurrentYear, oLayout = null;
}


function _fnGetSelectedYearRows(iIndex, sPrevious, sNext)
{
	var oCalendarArray	= oGlobalArray[iIndex];
	var oLayout			= new Array();

	oLayout.push("<tr>");
	oLayout.push("<td align='center' valign='middle' colspan='"+oCalendarArray['Day'].length+"' class='monthHeadingRow'>");

	oLayout.push("<table cellspacing='0' cellpadding='1' border='0' width='100%'>");
	oLayout.push("<tr class='monthHeadingRow_'>");

	oLayout.push("<td align='center' valign='middle' width='15'>");
	oLayout.push("<a href=\"javascript:_fnShowYears('"+iIndex+"', '"+sPrevious+"', undefined)\"");
	oLayout.push(" title='Previous 15 Years' class='linksCalendar_'>&lt;</a>");
	oLayout.push("</td>");

	oLayout.push("<td align='center' valign='middle'>Select Year</td>");
	oLayout.push("<td align='center' valign='middle' width='15'>");
	oLayout.push("<a href=\"javascript:_fnShowYears('"+iIndex+"', undefined, '"+sNext+"')\"");
	oLayout.push(" title='Next 15 Years' class='linksCalendar_'>&gt;</a>");
	oLayout.push("</td>");

	oLayout.push("</tr>");
	oLayout.push("</table>");

	oLayout.push("</td>");
	oLayout.push("</tr>");

	return oLayout.join('');
}


function _fnShowAllMonths(iIndex)
{
	var oCalendarArray	= oGlobalArray[iIndex];
	var iRecordPerRow	= 3;
	var iRowCounter		= 0;
	var iMonths			= 12;

	var oLayout			= new Array();

	oLayout.push(_fnGetTitleRow(iIndex));
	oLayout.push(_fnGetYearRow(iIndex));
	oLayout.push(_fnGetMonthRow(iIndex));

	for(iCounter = 0; iCounter < iMonths; iCounter++)
	{
		if(iRowCounter % iRecordPerRow == 0) oLayout.push("<tr>");

		oLayout.push("<td width='"+Math.floor((iMonths / iRecordPerRow) * 100)+"' class='monthCell_' onmouseover=\"this.className='monthOver_'\" onmouseout=\"this.className='monthCell_'\" onclick=\"_fnGetSelectedMonth('"+iIndex+"', _fnGetMonthNumber(this.innerHTML))\">");
		oLayout.push(_fnGetCalendarMonth(iCounter).substring(0,3) + "</td>");

		iRowCounter++;
		if(iRowCounter % iRecordPerRow == 0) oLayout.push("</tr>");
	}

	oLayout.push("</table>");

	oCalendarArray['Div'].innerHTML		= oLayout.join('');
	oCalendarArray['Div'].style.display	= 'inline';
	oCalendarArray, iRecordPerRow, iRowCounter, iMonths, oLayout = null;
}


function _fnAssignDate(iIndex, sDay)
{
	var oCalendarArray	= oGlobalArray[iIndex];
	var oDay			= oCalendarArray['Day'];
	var oDate			= oCalendarArray['Date'];
	oDate.setDate(sDay);
	var	oDateFormat		= new Array();
	var sMonth			= oDate.getMonth();
	var sDate			= oDate.getDate();
	var sHours			= oDate.getHours();
	var sMinutes		= oDate.getMinutes();
	var sSeconds		= oDate.getSeconds();
	
	sMonth				= (++sMonth) < 10 ? '0' + sMonth : sMonth;
	sDate				= sDate < 10 ? '0' + sDate : sDate;
	sHours				= sHours < 10 ? '0' + sHours : sHours;
	sMinutes			= sMinutes < 10 ? '0' + sMinutes : sMinutes;
	sSeconds			= sSeconds < 10 ? '0' + sSeconds : sSeconds;
	
	oDateFormat['FullYear']			= String(oDate.getFullYear());
	oDateFormat['Year']				= oDateFormat['FullYear'].substring(2,4);
	oDateFormat['FullMonthName']	= _fnGetCalendarMonth(oDate.getMonth());
	oDateFormat['MonthName']		= oDateFormat['FullMonthName'].substring(0,3);
	oDateFormat['Month']			= sMonth;
	oDateFormat['Date']				= sDate;
	oDateFormat['FullDay']			= oDay[oDate.getDay()];
	oDateFormat['Day']				= oDateFormat['FullDay'].substring(0, 3);
	oDateFormat['Hours']			= sHours;
	oDateFormat['Minutes']			= sMinutes;
	oDateFormat['Seconds']			= sSeconds;
	
	var sDateString;
	try
	{
		sDateString = fnSetDateFormat(oDateFormat);
		if(!sDateString)
			sDateString = oDateFormat['MonthName'] +"-"+ oDateFormat['Date'] +"-"+ oDateFormat['FullYear'];
	}
	catch(e)
	{
		sDateString = oDateFormat['FullYear'] +"-"+ oDateFormat['Month'] +"-"+ oDateFormat['Date'];
	}
	
	oCalendarArray['Input'].value = sDateString;
	
	if(oCalendarArray['Drop'])
		_fnShowsSelects(iIndex);
	
	if(oCalendarArray['Close'])
		_fnCloseCalendar(iIndex);
}


//**********************************************************

function _fnAddCalendarArray(oCalendarArray)
{
	var iArrayIndex = oGlobalArray.length;
	oGlobalArray.push(oCalendarArray);
	return iArrayIndex;
}

function _fnGetValue(sCustom, sValue)
{
	try
	{
		var oValue;
		var oCustom = sCustom.split(',');
		for(var iCounter = 0; iCounter < oCustom.length; iCounter++)
		{
			oValue = oCustom[iCounter].split('=');
			if(oValue[0] == sValue)
				return oValue[1];
		}
	}
	catch(e)
	{
		return null;
	}
}


function _fnClearValue(iIndex)
{
	var oCalendarArray	= oGlobalArray[iIndex];
	var oInput			= oCalendarArray['Input'];
	oInput.value		= '';
}


function _fnCloseCalendar(iIndex)
{
	var oCalendarArray		= oGlobalArray[iIndex];
	var oDiv				= oCalendarArray['Div'];
	
	if(oCalendarArray['Drop'])
		_fnShowsSelects(iIndex);
		
	oDiv.innerHTML			= '';
	oDiv.style.display		= 'none';
	oGlobalArray[iIndex]	= null;
}

function _fnShowsSelects(iIndex)
{
	var oCalendarArray		= oGlobalArray[iIndex];
	var oSelects			= oCalendarArray['Selects'];
	for(var counter = 0; counter < oSelects.length; counter++)
	{
		oSelects[counter].style.display = 'inline';
	}
}

var iCounterIndex = 500;
function _fnMoveDivAbove(iIndex)
{
	var oCalendarArray	= oGlobalArray[iIndex];
	var oDiv			= oCalendarArray['Div'];
	oDiv.style.zIndex	= ++iCounterIndex;
}



function _fnShowStatus(sMsg)
{
	window.status = sMsg;
	return false;
}



function _fnGetWeekDays()
{
	var oDays = new Array();

	oDays.push('Sunday');
	oDays.push('Monday');
	oDays.push('Tuesday');
	oDays.push('Wednesday');
	oDays.push('Thursday');
	oDays.push('Friday');
	oDays.push('Saturday');

	return oDays;
}



function _fnGetCalendarMonth(iMonth)
{
	var oMonths = new Array();

	oMonths.push('January');
	oMonths.push('February');
	oMonths.push('March');
	oMonths.push('April');
	oMonths.push('May');
	oMonths.push('June');
	oMonths.push('July');
	oMonths.push('August');
	oMonths.push('September');
	oMonths.push('October');
	oMonths.push('November');
	oMonths.push('December');

	return oMonths[iMonth];
}



function _fnGetMonthNumber(sMonthName)
{
	var oMonths = new Array();

	oMonths['Jan'] = '0';
	oMonths['Feb'] = '1';
	oMonths['Mar'] = '2';
	oMonths['Apr'] = '3';
	oMonths['May'] = '4';
	oMonths['Jun'] = '5';
	oMonths['Jul'] = '6';
	oMonths['Aug'] = '7';
	oMonths['Sep'] = '8';
	oMonths['Oct'] = '9';
	oMonths['Nov'] = '10';
	oMonths['Dec'] = '11';

	return oMonths[sMonthName];
}



function _fnGetDaysCount(iMonth, iYear)
{
	var oDaysCount = new Array();

	oDaysCount.push(31);
	oDaysCount.push(_fnIsLeapYear(iYear) ? 29 : 28);
	oDaysCount.push(31);
	oDaysCount.push(30);
	oDaysCount.push(31);
	oDaysCount.push(30);
	oDaysCount.push(31);
	oDaysCount.push(31);
	oDaysCount.push(30);
	oDaysCount.push(31);
	oDaysCount.push(30);
	oDaysCount.push(31);

	return oDaysCount[iMonth];
}


function _fnIsLeapYear(iYear)
{
	var bReturnValue;
	((iYear%4 == 0) && (iYear%100 != 0) || (iYear%400 == 0)) ? bReturnValue = true : bReturnValue = false;
	return bReturnValue;
}


//Drag
var Drag = {

	obj : null,

	init : function(o, oRoot, minX, maxX, minY, maxY, bSwapHorzRef, bSwapVertRef, fXMapper, fYMapper)
	{
		o.onmousedown	= Drag.start;

		o.hmode			= bSwapHorzRef ? false : true ;
		o.vmode			= bSwapVertRef ? false : true ;

		o.root = oRoot && oRoot != null ? oRoot : o ;

		if (o.hmode  && isNaN(parseInt(o.root.style.left  ))) o.root.style.left   = "0px";
		if (o.vmode  && isNaN(parseInt(o.root.style.top   ))) o.root.style.top    = "0px";
		if (!o.hmode && isNaN(parseInt(o.root.style.right ))) o.root.style.right  = "0px";
		if (!o.vmode && isNaN(parseInt(o.root.style.bottom))) o.root.style.bottom = "0px";

		o.minX	= typeof minX != 'undefined' ? minX : null;
		o.minY	= typeof minY != 'undefined' ? minY : null;
		o.maxX	= typeof maxX != 'undefined' ? maxX : null;
		o.maxY	= typeof maxY != 'undefined' ? maxY : null;

		o.xMapper = fXMapper ? fXMapper : null;
		o.yMapper = fYMapper ? fYMapper : null;

		o.root.onDragStart	= new Function();
		o.root.onDragEnd	= new Function();
		o.root.onDrag		= new Function();
	},

	start : function(e)
	{
		var o = Drag.obj = this;
		e = Drag.fixE(e);
		var y = parseInt(o.vmode ? o.root.style.top  : o.root.style.bottom);
		var x = parseInt(o.hmode ? o.root.style.left : o.root.style.right );
		o.root.onDragStart(x, y);

		o.lastMouseX	= e.clientX;
		o.lastMouseY	= e.clientY;

		if (o.hmode) {
			if (o.minX != null)	o.minMouseX	= e.clientX - x + o.minX;
			if (o.maxX != null)	o.maxMouseX	= o.minMouseX + o.maxX - o.minX;
		} else {
			if (o.minX != null) o.maxMouseX = -o.minX + e.clientX + x;
			if (o.maxX != null) o.minMouseX = -o.maxX + e.clientX + x;
		}

		if (o.vmode) {
			if (o.minY != null)	o.minMouseY	= e.clientY - y + o.minY;
			if (o.maxY != null)	o.maxMouseY	= o.minMouseY + o.maxY - o.minY;
		} else {
			if (o.minY != null) o.maxMouseY = -o.minY + e.clientY + y;
			if (o.maxY != null) o.minMouseY = -o.maxY + e.clientY + y;
		}

		document.onmousemove	= Drag.drag;
		document.onmouseup	= Drag.end;

		return false;
	},

	drag : function(e)
	{
		e = Drag.fixE(e);
		var o = Drag.obj;

		var ey	= e.clientY;
		var ex	= e.clientX;
		var y = parseInt(o.vmode ? o.root.style.top  : o.root.style.bottom);
		var x = parseInt(o.hmode ? o.root.style.left : o.root.style.right );
		var nx, ny;

		if (o.minX != null) ex = o.hmode ? Math.max(ex, o.minMouseX) : Math.min(ex, o.maxMouseX);
		if (o.maxX != null) ex = o.hmode ? Math.min(ex, o.maxMouseX) : Math.max(ex, o.minMouseX);
		if (o.minY != null) ey = o.vmode ? Math.max(ey, o.minMouseY) : Math.min(ey, o.maxMouseY);
		if (o.maxY != null) ey = o.vmode ? Math.min(ey, o.maxMouseY) : Math.max(ey, o.minMouseY);

		nx = x + ((ex - o.lastMouseX) * (o.hmode ? 1 : -1));
		ny = y + ((ey - o.lastMouseY) * (o.vmode ? 1 : -1));

		if (o.xMapper)		nx = o.xMapper(y)
		else if (o.yMapper)	ny = o.yMapper(x)

		Drag.obj.root.style[o.hmode ? "left" : "right"] = nx + "px";
		Drag.obj.root.style[o.vmode ? "top" : "bottom"] = ny + "px";
		Drag.obj.lastMouseX	= ex;
		Drag.obj.lastMouseY	= ey;

		Drag.obj.root.onDrag(nx, ny);
		return false;
	},

	end : function()
	{
		document.onmousemove = null;
		document.onmouseup   = null;
		Drag.obj.root.onDragEnd(	parseInt(Drag.obj.root.style[Drag.obj.hmode ? "left" : "right"]), 
						parseInt(Drag.obj.root.style[Drag.obj.vmode ? "top" : "bottom"]));
		Drag.obj = null;
	},

	fixE : function(e)
	{
		if (typeof e == 'undefined') e = window.event;
		if (typeof e.layerX == 'undefined') e.layerX = e.offsetX;
		if (typeof e.layerY == 'undefined') e.layerY = e.offsetY;
		return e;
	}
};