package com.groupdocs.examples.conversion;

import com.groupdocs.examples.conversion.advanced_usage.caching.CustomCacheImplementation;
import com.groupdocs.examples.conversion.advanced_usage.common.AddWatermark;
import com.groupdocs.examples.conversion.advanced_usage.common.ConvertNConsecutivePages;
import com.groupdocs.examples.conversion.advanced_usage.common.ConvertSpecificPages;
import com.groupdocs.examples.conversion.advanced_usage.common.ListenConversionStateAndProgress;
import com.groupdocs.examples.conversion.advanced_usage.loading.LoadPasswordProtectedDocument;
import com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.cad.ConvertCadAndSpecifyLayouts;
import com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.cad.ConvertCadAndSpecifyWidthAndHeight;
import com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.csv.ConvertCsvByConvertingDateTimeAndNumericData;
import com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.csv.ConvertCsvBySpecifyingDelimiter;
import com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.csv.ConvertCsvBySpecifyingEncoding;
import com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.email.ConvertEmailWithAlteringFieldsVisibility;
import com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.email.ConvertEmailWithTimezoneOffset;
import com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.note.ConvertNoteBySpecifyingFontSubstitution;
import com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.pdf.ConvertPdfAndFlattenAllFields;
import com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.pdf.ConvertPdfAndHideAnnotations;
import com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.pdf.ConvertPdfAndRemoveEmbeddedFiles;
import com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.presentation.ConvertPresentationByHidingComments;
import com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.presentation.ConvertPresentationBySpecifyingFontSubstitution;
import com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.presentation.ConvertPresentationWithHiddenSlidesIncluded;
import com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.spreadsheet.*;
import com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.txt.ConvertTxtByControllingLeadingSpacesBehavior;
import com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.txt.ConvertTxtByControllingTrailingSpacesBehavior;
import com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.txt.ConvertTxtBySpecifyingEncoding;
import com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.word_processing.ConvertWordProcessingByHidingComments;
import com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.word_processing.ConvertWordProcessingByHidingTrackedChanges;
import com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.word_processing.ConvertWordProcessingBySpecifyingFontSubstitution;
import com.groupdocs.examples.conversion.advanced_usage.loading.by_document_type.xml.ConvertXmlAsDataSourceToSpreadsheet;
import com.groupdocs.examples.conversion.advanced_usage.loading.from_different_sources.FromLocalDisk;
import com.groupdocs.examples.conversion.advanced_usage.loading.from_different_sources.FromStream;
import com.groupdocs.examples.conversion.advanced_usage.loading.from_different_sources.FromUrl;
import com.groupdocs.examples.conversion.advanced_usage.specifying_options.*;
import com.groupdocs.examples.conversion.basic_usage.GetAllSupportedConversions;
import com.groupdocs.examples.conversion.basic_usage.GetSourceDocumentInfo;
import com.groupdocs.examples.conversion.basic_usage.GetSupportedConversionsForFile;
import com.groupdocs.examples.conversion.basic_usage.convert_from.ConvertFromCompression;
import com.groupdocs.examples.conversion.basic_usage.convert_to.*;
import com.groupdocs.examples.conversion.quick_start.HelloWorld;
import com.groupdocs.examples.conversion.quick_start.licensing.SetLicenseFromStream;
import com.groupdocs.examples.conversion.utils.FailureRegister;

public class Main {
    public static void main(String[] args) {
        System.out.println("Open `src/main/java/com/groupdocs/examples/conversion/Main.java` file. \nIn runExamples() method uncomment the example that you want to run.");
        System.out.println("=====================================================");

        runExamples();

        final boolean printFailedSamplesStacktrace = System.getenv("PRINT_FAILED_SAMPLES_STACKTRACE") != null;
        FailureRegister.getInstance().printFailedSamples(printFailedSamplesStacktrace);

        System.out.println("\nAll done.");
        System.exit(FailureRegister.getInstance().getFailedSamplesCount());
    }

    public static void runExamples() {
        // TODO: Comment examples which you don't want to run

        { // Licensing
//            SetLicenseFromFile.run();
            SetLicenseFromStream.run();
//            SetMeteredLicense.run();
        }
        { // Quick start
            HelloWorld.run(SampleFiles.SAMPLE_DOCX);
        }
        { // Basic usage
            GetAllSupportedConversions.run();
            GetSupportedConversionsForFile.run(SampleFiles.SAMPLE_DOCX);
            GetSourceDocumentInfo.run(SampleFiles.SAMPLE_PDF);

            { // Convert from
                ConvertFromCompression.run(SampleFiles.SAMPLE_ZIP);
            }
            { // Convert to
                ConvertToHtml.run(SampleFiles.SAMPLE_DOCX);
                ConvertToJpg.run(SampleFiles.SAMPLE_PDF);
                ConvertToPng.run(SampleFiles.SAMPLE_PDF);
                ConvertToPsd.run(SampleFiles.SAMPLE_VSDX);
                ConvertToPdf.run(SampleFiles.SAMPLE_DOCX);
                ConvertToPresentation.run(SampleFiles.SAMPLE_DOCX);
                ConvertToSpreadsheet.run(SampleFiles.SAMPLE_DOCX);
                ConvertToWordProcessing.run(SampleFiles.SAMPLE_PDF);
            }
        }
        { // Advanced usage
            { // Common
                AddWatermark.run(SampleFiles.SAMPLE_PDF);
                ConvertNConsecutivePages.run(SampleFiles.SAMPLE_DOCX);
                ConvertSpecificPages.run(SampleFiles.SAMPLE_DOCX);
                ListenConversionStateAndProgress.run(SampleFiles.SAMPLE_DOCX);
            }
            { // Caching
                CustomCacheImplementation.run(SampleFiles.SAMPLE_DOCX);
            }
            { // Options
                ConvertToHtmlWithAdvancedOptions.run(SampleFiles.SAMPLE_DOCX_WITH_PASSWORD);
                ConvertToImageWithAdvancedOptions.run(SampleFiles.SAMPLE_PDF);
                ConvertToPdfWithAdvancedOptions.run(SampleFiles.SAMPLE_DOCX_WITH_PASSWORD);
                ConvertToPresentationWithAdvancedOptions.run(SampleFiles.SAMPLE_DOCX_WITH_PASSWORD);
                ConvertToSpreadsheetWithAdvancedOptions.run(SampleFiles.SAMPLE_DOCX_WITH_PASSWORD);
                ConvertToWordProcessingWithAdvancedOptions.run(SampleFiles.SAMPLE_PDF);
            }
            { // Loading
                LoadPasswordProtectedDocument.run(SampleFiles.SAMPLE_DOCX_WITH_PASSWORD);

                { // From different sources
//                    FromAmazonS3.run("sample.docx", "<AWS accessKey>", "<AWS secretKey>", "my-bucket");
//                    FromAzureBlobStorage.run("sample.docx", "Azure accountName", "Azure accountKey", "Azure containerName")
//                    FromFtp.run("sample.docx", "FTP server", "FTP username", "FTP password");
                    FromLocalDisk.run(SampleFiles.SAMPLE_DOCX);
                    FromStream.run(SampleFiles.SAMPLE_DOCX);
                    FromUrl.run("https://github.com/groupdocs-conversion/GroupDocs.Conversion-for-.NET/blob/master/Examples/GroupDocs.Conversion.Examples.CSharp/Resources/SampleFiles/sample.docx?raw=true");
                }
                { // By document type
                    ConvertCadAndSpecifyLayouts.run(SampleFiles.SAMPLE_DWG_WITH_LAYOUTS_AND_LAYERS);
                    ConvertCadAndSpecifyWidthAndHeight.run(SampleFiles.SAMPLE_DWG_WITH_LAYOUTS_AND_LAYERS);

                    ConvertCsvByConvertingDateTimeAndNumericData.run(SampleFiles.SAMPLE_CSV);
                    ConvertCsvBySpecifyingDelimiter.run(SampleFiles.SAMPLE_CSV);
                    ConvertCsvBySpecifyingEncoding.run(SampleFiles.SAMPLE_CSV);

                    ConvertEmailWithAlteringFieldsVisibility.run(SampleFiles.SAMPLE_MSG);
                    ConvertEmailWithTimezoneOffset.run(SampleFiles.SAMPLE_EML);

                    ConvertNoteBySpecifyingFontSubstitution.run(SampleFiles.SAMPLE_ONE);

                    ConvertPdfAndFlattenAllFields.run(SampleFiles.SAMPLE_PDF);
                    ConvertPdfAndHideAnnotations.run(SampleFiles.SAMPLE_PDF);
                    ConvertPdfAndRemoveEmbeddedFiles.run(SampleFiles.SAMPLE_PDF);

                    ConvertPresentationByHidingComments.run(SampleFiles.PPTX_WITH_NOTES);
                    ConvertPresentationBySpecifyingFontSubstitution.run(SampleFiles.PPTX_WITH_NOTES);
                    ConvertPresentationWithHiddenSlidesIncluded.run(SampleFiles.SAMPLE_PPTX_HIDDEN_PAGE);

                    ConvertSpreadsheetAndHideComments.run(SampleFiles.SAMPLE_XLSX);
                    ConvertSpreadsheetByShowingGridLines.run(SampleFiles.SAMPLE_XLSX);
                    ConvertSpreadsheetBySkippingEmptyRowsAndColumns.run(SampleFiles.SAMPLE_XLSX);
                    ConvertSpreadsheetBySpecifyingFontSubstitution.run(SampleFiles.SAMPLE_XLSX);
                    ConvertSpreadsheetBySpecifyingRange.run(SampleFiles.SAMPLE_XLSX);
                    ConvertSpreadsheetWithHiddenSheetsIncluded.run(SampleFiles.SAMPLE_XLSX_WITH_HIDDEN_SHEET);

                    ConvertTxtByControllingLeadingSpacesBehavior.run(SampleFiles.SAMPLE_TXT);
                    ConvertTxtByControllingTrailingSpacesBehavior.run(SampleFiles.SAMPLE_TXT);
                    ConvertTxtBySpecifyingEncoding.run(SampleFiles.SAMPLE_TXT_SHIFT_JS_ENCODED);

                    ConvertWordProcessingByHidingComments.run(SampleFiles.SAMPLE_DOCX_WITH_TRACKED_CHANGES);
                    ConvertWordProcessingByHidingTrackedChanges.run(SampleFiles.SAMPLE_DOCX_WITH_TRACKED_CHANGES);
                    ConvertWordProcessingBySpecifyingFontSubstitution.run(SampleFiles.SAMPLE_DOCX_WITH_TRACKED_CHANGES);

                    ConvertXmlAsDataSourceToSpreadsheet.run(SampleFiles.SAMPLE_XML_DATASOURCE);
                }
            }
        }
    }
}
