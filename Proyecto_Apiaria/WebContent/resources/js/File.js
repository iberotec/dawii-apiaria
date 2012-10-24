$(".txtFile").change(function() {
	var file = $(".txtFile").val();
	$(".txtTipoDocumento").val(obtenerTipoArchivo(file));
});

// retorna el tipo de archivo
function obtenerTipoArchivo(file) {
	x = getExtension(file).toUpperCase();
	var f = "OTRO / "+x;
	switch (getExtension(x)) {
	// DOCUMENTO
	case 'DIC':
	case 'DOC':
	case 'DOCX':
	case 'DIZ':
	case 'DOCHTML':
	case 'EXC':
	case 'IDX':
	case 'LOG':
	case 'PDF':
	case 'RTF':
	case 'SCP':
	case 'TXT':
	case 'WRI':
	case 'WTX':
	case 'SDC':
	case 'SDW':
	case 'STC':
	case 'STW':
	case 'SXD':
	case 'SXW':
	case 'DOT':
	case 'DOTHTML':
	case 'WBK':
	case 'WIZ':
	case 'CSV':
	case 'DIF':
	case 'XLB':
	case 'XLC':
	case 'XLS':
	case 'XLSHTML':
		f = "DOCUMENTO / " + x;
		break;
	// IMAGEN
	case 'AIS':
	case 'BMP':
	case 'BW':
	case 'CDR':
	case 'CDT':
	case 'CGM':
	case 'CMX':
	case 'CPT':
	case 'DCX':
	case 'DIB':
	case 'EMF':
	case 'GBR':
	case 'GIF':
	case 'GIH':
	case 'ICO':
	case 'IFF':
	case 'ILBM':
	case 'JFIF':
	case 'JIF':
	case 'JPE':
	case 'JPEG':
	case 'JPG':
	case 'KDC':
	case 'LBM':
	case 'MAC':
	case 'PAT':
	case 'PCD':
	case 'PCT':
	case 'PCX':
	case 'PIC':
	case 'PICT':
	case 'PNG':
	case 'PNTG':
	case 'PIX':
	case 'PSD':
	case 'PSP':
	case 'QTI':
	case 'QTIF':
	case 'RGB':
	case 'RGBA':
	case 'RIF':
	case 'RLE':
	case 'SGI':
	case 'TGA':
	case 'TIF':
	case 'TIFF':
	case 'WMF':
	case 'XCF':
		f = "IMAGEN / " + x;
		break;
	// VIDEO
	case 'ASF':
	case 'AVI':
	case 'BIK':
	case 'DIV':
	case 'DIVX':
	case 'DVD':
	case 'IVF':
	case 'M1V':
	case 'MOV':
	case 'MOVIE':
	case 'MP2V':
	case 'MP4':
	case 'MPA':
	case 'MPE':
	case 'MPEG':
	case 'MPG':
	case 'QT':
	case 'QTL':
	case 'RPM':
	case 'SMK':
	case 'WM':
	case 'WMV':
	case 'WOB':
		f = "VIDEO / " + x;
		break;

	// AUDIO
	case '669':
	case 'AIF':
	case 'AIFC':
	case 'AIFF':
	case 'AMF':
	case 'ASF':
	case 'AU':
	case 'AUDIOCD':
	case 'CDA':
	case 'CDDA':
	case 'FAR':
	case 'IT':
	case 'ITZ':
	case 'LWV':
	case 'MID':
	case 'MIDI':
	case 'MIZ':
	case 'MP1':
	case 'MP2':
	case 'MP3':
	case 'MTM':
	case 'OGG':
	case 'AMF':
	case 'OGM':
	case 'OKT':
	case 'RA':
	case 'RMI':
	case 'SND':
	case 'STM':
	case 'STZ':
	case 'ULT':
	case 'VOC':
	case 'WAV':
	case 'WAX':
	case 'WM':
	case 'WMA':
	case 'WMV':
	case 'XM':
	case 'XMZ':
		f = "AUDIO / " + x;
		break;
	default:
		var f = "OTRO / " + x;
	}
	return f;
}

function getExtension(filename) {
	return filename.split('.').pop().toUpperCase();
}