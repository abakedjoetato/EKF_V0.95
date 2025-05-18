import zipfile
import os
import shutil

def extract_and_organize():
    # Path to the zip file
    zip_path = 'attached_assets/EKF_V0.9-main.zip'
    
    # Create a temporary extraction directory
    temp_dir = 'temp_unzip'
    if os.path.exists(temp_dir):
        shutil.rmtree(temp_dir)
    os.makedirs(temp_dir)
    
    # Extract the zip file
    print(f"Extracting {zip_path} to {temp_dir}...")
    with zipfile.ZipFile(zip_path, 'r') as zip_ref:
        zip_ref.extractall(temp_dir)
    
    # Find the root directory in the extracted content
    extracted_dirs = [d for d in os.listdir(temp_dir) if os.path.isdir(os.path.join(temp_dir, d))]
    if not extracted_dirs:
        print("No directories found in the extracted content.")
        return
    
    root_dir = os.path.join(temp_dir, extracted_dirs[0])
    print(f"Found root directory: {root_dir}")
    
    # Copy all files from the root directory to the project root
    for item in os.listdir(root_dir):
        src = os.path.join(root_dir, item)
        dst = os.path.join('.', item)
        
        if os.path.isdir(src):
            # If directory already exists, merge the contents
            if os.path.exists(dst):
                print(f"Merging directory: {item}")
                for subitem in os.listdir(src):
                    subsrc = os.path.join(src, subitem)
                    subdst = os.path.join(dst, subitem)
                    if os.path.isdir(subsrc):
                        if not os.path.exists(subdst):
                            shutil.copytree(subsrc, subdst)
                    else:
                        shutil.copy2(subsrc, subdst)
            else:
                print(f"Copying directory: {item}")
                shutil.copytree(src, dst)
        else:
            # Copy files, but don't overwrite existing files
            if not os.path.exists(dst):
                print(f"Copying file: {item}")
                shutil.copy2(src, dst)
    
    print("Extraction and organization complete!")

if __name__ == "__main__":
    extract_and_organize()