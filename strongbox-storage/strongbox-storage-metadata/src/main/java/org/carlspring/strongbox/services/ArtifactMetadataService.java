package org.carlspring.strongbox.services;

import org.apache.maven.artifact.Artifact;
import org.apache.maven.artifact.repository.metadata.Metadata;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;

/**
 * @author stodorov
 */
public interface ArtifactMetadataService extends ConfigurationService
{

    /**
     * Get artifact metadata using artifactPath(string) instead of Artifact.
     *
     * @param storageId     String
     * @param repositoryId  String
     * @param artifactPath  String
     *
     * @return Metadata
     *
     * @throws IOException
     * @throws XmlPullParserException
     */
    Metadata getMetadata(String storageId, String repositoryId, String artifactPath)
            throws IOException, XmlPullParserException;

    /**
     * Get artifact metadata.
     *
     * @param artifactBasePath  The base path of the artifact
     *
     * @return Metadata
     *
     * @throws IOException
     * @throws XmlPullParserException
     */
    Metadata getMetadata(String artifactBasePath)
            throws IOException, XmlPullParserException;

    /**
     * Get artifact metadata using an InputStream.
     *
     * @return Metadata
     *
     * @throws IOException
     * @throws XmlPullParserException
     */
    Metadata getMetadata(InputStream is)
            throws IOException, XmlPullParserException;

    /**
     * Rebuild metadata for artifact using artifactPath (string)
     *
     * @param storageId     String
     * @param repositoryId  String
     * @param artifactPath  String
     *
     * @throws IOException
     * @throws XmlPullParserException
     */
    void rebuildMetadata(String storageId, String repositoryId, String artifactPath)
            throws IOException, XmlPullParserException, NoSuchAlgorithmException;

    /**
     * Merge existing artifact metadata with mergeMetadata.
     *
     * @param storageId     String
     * @param repositoryId  String
     * @param artifact      Artifact
     * @param mergeMetadata Metadata
     *
     * @throws IOException
     * @throws XmlPullParserException
     */
    void mergeMetadata(String storageId, String repositoryId, Artifact artifact, Metadata mergeMetadata)
            throws IOException, XmlPullParserException, NoSuchAlgorithmException;

}