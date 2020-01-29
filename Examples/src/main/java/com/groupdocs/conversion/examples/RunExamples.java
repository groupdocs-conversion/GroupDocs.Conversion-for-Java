package com.groupdocs.conversion.examples;

import com.groupdocs.conversion.examples.advanced_usage.converting.*;
import com.groupdocs.conversion.examples.advanced_usage.converting.common.AddWatermark;
import com.groupdocs.conversion.examples.advanced_usage.converting.common.ConvertSpecificPages;
import com.groupdocs.conversion.examples.advanced_usage.listening.ListenConversionStateAndProgress;
import com.groupdocs.conversion.examples.advanced_usage.loading.LoadPasswordProtectedDocument;
import com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.cad.ConvertCadAndSpecifyLayouts;
import com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.cad.ConvertCadAndSpecifyWidthAndHeight;
import com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.csv.ConvertCsvByConvertingDateTimeAndNumericData;
import com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.csv.ConvertCsvBySpecifyingDelimiter;
import com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.csv.ConvertCsvBySpecifyingEncoding;
import com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.email.ConvertEmailWithAlteringFieldsVisibility;
import com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.email.ConvertEmailWithTimezoneOffset;
import com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.note.ConvertNoteBySpecifyingFontSubstitution;
import com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.pdf.ConvertPdfAndFlattenAllFields;
import com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.pdf.ConvertPdfAndHideAnnotations;
import com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.pdf.ConvertPdfAndRemoveEmbeddedFiles;
import com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.presentation.ConvertPresentationByHiddingComments;
import com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.presentation.ConvertPresentationBySpecifyingFontSubstitution;
import com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.presentation.ConvertPresentationWithHiddenSlidesIncluded;
import com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.spreadsheet.*;
import com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.word_processing.ConvertWordProcessingByHiddingComments;
import com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.word_processing.ConvertWordProcessingByHiddingTrackedChanges;
import com.groupdocs.conversion.examples.advanced_usage.loading.load_options_by_document_type.word_processing.ConvertWordProcessingBySpecifyingFontSubstitution;
import com.groupdocs.conversion.examples.advanced_usage.loading.loading_documents_from_different_sources.*;
import com.groupdocs.conversion.examples.basic_usage.GetPossibleConversions;
import com.groupdocs.conversion.examples.basic_usage.GetSourceDocumentInfo;
import com.groupdocs.conversion.examples.basic_usage.convert_to_html.ConvertToHtml;
import com.groupdocs.conversion.examples.basic_usage.convert_to_image.ConvertToJpg;
import com.groupdocs.conversion.examples.basic_usage.convert_to_image.ConvertToPng;
import com.groupdocs.conversion.examples.basic_usage.convert_to_image.ConvertToPsd;
import com.groupdocs.conversion.examples.basic_usage.convert_to_presentation.ConvertToPresentation;
import com.groupdocs.conversion.examples.basic_usage.convert_to_spreadsheet.ConvertToSpreadsheet;
import com.groupdocs.conversion.examples.basic_usage.convert_to_word_processing.ConvertToWordProcessing;
import com.groupdocs.conversion.examples.basic_usage.ñonvert_to_pdf.ConvertToPdf;
import com.groupdocs.conversion.examples.quick_start.HelloWorld;
import com.groupdocs.conversion.examples.quick_start.SetLicenseFromFile;
import com.groupdocs.conversion.examples.quick_start.SetLicenseFromStream;
import com.groupdocs.conversion.examples.quick_start.SetMeteredLicense;

public class RunExamples {

	public static void main(String[] args) throws Throwable {

        System.out.print("Open RunExamples.cs. \nIn Main() method uncomment the example that you want to run.");
        System.out.print("=====================================================");

        //NOTE: Please uncomment the example you want to try out

        //region Quick Start

        SetLicenseFromFile.run();
        SetLicenseFromStream.run();
        SetMeteredLicense.run();
        HelloWorld.run();

        //endregion

        //region Basic Usage

        GetPossibleConversions.run();
        GetSourceDocumentInfo.run();

        //region Convert document to HTML

        ConvertToHtml.run();

        //endregion

        //region Convert document to Image

        ConvertToJpg.run();
        ConvertToPng.run();
        ConvertToPsd.run();

        //endregion

        //region Convert document to PDF

        ConvertToPdf.run();

        //endregion

        //region Convert document to Presentation

        ConvertToPresentation.run();

        //endregion

        //region Convert document to Spreadsheet

        ConvertToSpreadsheet.run();

        //endregion

        //region Convert document to WordProcessing

        ConvertToWordProcessing.run();

        //endregion

        //endregion

        //region Advanced Usage

        //region Common rendering options


        AddWatermark.run();
        ConvertSpecificPages.run();

        //endregion

        //region Loading

        LoadPasswordProtectedDocument.run();

        //region Loading documents from different sources

        LoadDocumentFromLocalDisk.run();
        LoadDocumentFromStream.run();
        LoadDocumentFromUrl.run();
        LoadDocumentFromFtp.run();
        LoadDocumentFromAmazonS3.run();
        LoadDocumentFromAzureBlobStorage.run();

        //endregion

        //region Load options by document type

        //region Cad

        ConvertCadAndSpecifyLayouts.run();
        ConvertCadAndSpecifyWidthAndHeight.run();

        //endregion

        //region Csv

        ConvertCsvByConvertingDateTimeAndNumericData.run();
        ConvertCsvBySpecifyingDelimiter.run();
        ConvertCsvBySpecifyingEncoding.run();

        //endregion

        //region Email

        ConvertEmailWithAlteringFieldsVisibility.run();
        ConvertEmailWithTimezoneOffset.run();

        //endregion

        //region Note

        ConvertNoteBySpecifyingFontSubstitution.run();

        //endregion

        //region Pdf

        ConvertPdfAndFlattenAllFields.run();
        ConvertPdfAndHideAnnotations.run();
        ConvertPdfAndRemoveEmbeddedFiles.run();

        //endregion

        //region Presentation

        ConvertPresentationByHiddingComments.run();
        ConvertPresentationBySpecifyingFontSubstitution.run();
        ConvertPresentationWithHiddenSlidesIncluded.run();

        //endregion

        //region Spreadsheet

        ConvertSpreadsheetAndHideComments.run();
        ConvertSpreadsheetByShowingGridLines.run();
        ConvertSpreadsheetBySkippingEmptyRowsAndColumns.run();
        ConvertSpreadsheetBySpecifyingFontsubstitution.run();
        ConvertSpreadsheetBySpecifyingRange.run();
        ConvertSpreadsheetWithHiddenSheetsIncluded.run();

        //endregion

        //region WordProcessing

        ConvertWordProcessingByHiddingComments.run();
        ConvertWordProcessingByHiddingTrackedChanges.run();
        ConvertWordProcessingBySpecifyingFontSubstitution.run();

        //endregion

        //endregion

        //endregion

        ConvertToHtmlWithAdvancedOptions.run();
        ConvertToImageWithAdvancedOptions.run();
        ConvertToPdfWithAdvancedOptions.run();
        ConvertToPresentationWithAdvancedOptions.run();
        ConvertToSpreadsheetWithAdvancedOptions.run();
        ConvertToWordProcessingWithAdvancedOptions.run();

        ListenConversionStateAndProgress.run();

        //endregion

        System.out.print("\nAll done.");

	
	}
}
