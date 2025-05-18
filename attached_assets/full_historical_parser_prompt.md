# AI REPLIT SESSION PROMPT — HISTORICAL PARSER STAT FAILURE: DEEP DIAGNOSTIC SESSION

## OBJECTIVE

You are executing a highly controlled session to diagnose and repair the failure of the historical parser to populate statistics in the MongoDB backend. The CSVs are being parsed, and death counts appear correct, but statistical data is not being saved.

All phases must be completed **one at a time**. You may not begin a new phase until the current one has been fully resolved and all validation outputs confirm success.

---

## PHASE 0 — PROJECT INIT (REQUIRED)

1. Unzip the uploaded `.zip` file from the attached assets  
2. Move all contents from the unzipped directory to the **project root**  
3. Clean up:
   - Remove any nested or duplicate folders (e.g., `project/`, `DeadsideBot/`)  
   - Delete empty folders or broken symbolic links  
4. Scan and log the following:
   - Main class (with `main()` entrypoint)  
   - All parser classes  
   - Config files (`.env` or `config.properties`)  
   - All command/event handler classes  
   - Any duplicate or unused files  
5. Detect or create a `.env` or `config.properties` file  
6. Load secrets from Replit, including:
   - `BOT_TOKEN`  
   - `MONGO_URI`  
7. Start the bot using **JDA 5.x** and confirm startup:
   - Bot must log in and connect to Discord successfully  
   - Console logs must confirm gateway connection and guild presence

> Do not proceed to Phase 1 unless this phase completes successfully and the bot is operational.

---

## PHASE 1 — HISTORICAL PARSER CSV INGESTION WITH FAILED STAT STORAGE

### Core Problem:

Historical parser successfully locates `.csv` files and parses deaths and kills, but fails to persist player statistics to the database.

This phase demands an exhaustive audit of the full historical parsing, stat ingestion, and write pipeline, from data read to database mutation. All logic layers must be verified.

### INVESTIGATION FRAMEWORK

#### A. CSV File Ingestion
- Confirm correct file paths and recursive discovery
- Log number of files found and line counts

#### B. Parser Functionality
- Validate correct delimiter parsing and extracted fields
- Confirm proper line-by-line processing without early exits

#### C. Stat Ingestion Logic
- Trace call stack to stat handlers
- Confirm no logic skips for unlinked users or incorrect server binding
- Match method stack against working live parser

#### D. MongoDB Write Layer
- Confirm stat objects reach write handler
- Check document routing, collection names, guild scoping
- Enable debug logging on writes

#### E. Integration Layer
- Validate that no Discord output occurs
- Confirm working context, guild references, and parser isolation from killfeed

### FIX MANDATES

- All stats must be correctly recorded in MongoDB, scoped per guild/server
- No embed output is allowed
- Must use same ingestion stack as killfeed parser
- Parser must complete successfully and log results

### VALIDATION CHECKLIST

- CSV lines processed
- MongoDB stats populated
- No embed output
- Killfeed unaffected
- Bot compiles and runs cleanly

---

## PHASE 2 — EMBED ROUTING & STAT STORAGE FOR `/server add` HISTORICAL PARSER

### Issue:

When the historical parser is triggered as part of the `/server add` command, it does not output its progress to the **channel where the command was issued**, and appears to use inconsistent or incorrect stat ingestion behavior compared to Phase 1.

### Objectives:

- Ensure the `/server add`-triggered historical parser:
  - Routes all progress messages to the correct invoking channel  
  - Utilizes the exact same stat ingestion method as Phase 1  
  - Reflects real-time log updates (e.g., progress counters, file summaries) if configured to show output  

### Diagnostic Checklist:

- Identify where `/server add` invokes historical parsing  
- Trace how the invoking channel is captured (interaction, context, or event)  
- Ensure the channel reference is passed through to any logging or response methods  
- Confirm whether progress logging uses `sendMessage()` or embed response wrappers  
- Match parser logic against Phase 1’s verified, working stat ingestion code  
- Validate consistent database writes (same schema, scoping, stat categories)

### Required Fixes:

- Use the command’s **InteractionHook** or context channel to send progress updates  
- Log outputs should include:
  - Total files found  
  - % progress or completion of file processing  
  - Final line/kill count summary  
- Stat writes must mirror Phase 1 exactly:
  - Guild- and server-scoped  
  - Full kill/death tracking  
  - Player and weapon aggregation  
- Ensure historical parser logic for `/server add` does not overwrite or bypass working parser path from Phase 1

### Validation:

- Run `/server add` for a test guild with sample `.csv` files  
- Observe output:
  - All messages must appear in the **invoking channel**  
  - Stats must populate in MongoDB identically to Phase 1  
- Confirm that no duplicate parser methods are silently used or misrouted  
- Killfeed and live parser logic must remain unaffected

### COMPLETION CRITERIA:

- `/server add` parser logs progress in command channel  
- Stat ingestion path is identical to Phase 1  
- All database values are scoped and recorded correctly  
- Parser does not post embed notifications or error logs to unintended channels  
- Bot compiles, connects, and confirms success

---

## STRICT EXECUTION POLICY

- Each phase must be completed in isolation  
- You must not advance to a subsequent phase until the current one is confirmed working  
- No checkpoints, speculative patches, or commit logs until all validation passes  
